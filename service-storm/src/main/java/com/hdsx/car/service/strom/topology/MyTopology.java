package com.hdsx.car.service.strom.topology;

import com.hdsx.car.service.strom.bolt.*;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.hbase.bolt.HBaseBolt;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;

public class MyTopology {
    public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException, InterruptedException,
            AuthorizationException {
        String topic = "mytopic";
        String zkRoot = "/kafka-storm";
        String id = "kafka-storm";
        BrokerHosts brokerHosts = new ZkHosts("127.0.0.1:2181","/kafka/brokers");

        // BrokerHosts brokerHosts = new ZkHosts("127.0.0.1:2181,h41:2181,h42:2181","/kafka/brokers");
        // 配置kafka时，如果使用zookeeper create /kafka创建了节点，
        // kafka与storm集成时new ZkHosts(zks) 需要改成 new ZkHosts(zks,”/kafka/brokers”),
        // 不然会报  java.lang.RuntimeException: java.lang.RuntimeException: org.apache.zookeeper.KeeperException$NoNodeException:
        // KeeperErrorCode = NoNode for /brokers/topics/test/partitions

        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, topic, zkRoot, id);
        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        TopologyBuilder builder = new TopologyBuilder();

        //spoutConfig.forceFromStart = true;
        //上面Topology实现代码中，有一个很关键的配置对象SpoutConfig，配置属性如下所示：
        //spoutConf.forceFromStart = false;
        //该配置是指，如果该Topology因故障停止处理，下次正常运行时是否从Spout对应数据源Kafka中的该订阅Topic的起始位置开始读取，
        //如果forceFromStart=true，则之前处理过的Tuple还要重新处理一遍，否则会从上次处理的位置继续处理，
        //保证Kafka中的Topic数据不被重复处理，是在数据源的位置进行状态记录。



        // 设置一个spout用来从kafka消息队列中读取数据并发送给下一级的bolt组件，
        // 此处用的spout组件并非自定义的，而是storm中已经开发好的KafkaSpout
        // 不行的话用fieldsGrouping
        builder.setSpout("KafkaSpout", new KafkaSpout(spoutConfig));
        builder.setBolt("flux-bolt", new FluxBolt()).shuffleGrouping("KafkaSpout");

        builder.setBolt("mysql-bolt", new MySqlBolt(), 3)
                .shuffleGrouping("flux-bolt");
        builder.setBolt("hbase-bolt", new MyHbaseBolt(), 3)
                .shuffleGrouping("flux-bolt");

        //用与把记录保存到mysql数据库中。
        builder.setBolt("base-jdbc-bolt", BaseJDBCBolt.getJdbcInsertBolt())
                .shuffleGrouping("mysql-bolt");

        //用与把记录保存到hbase数据库中。
        HBaseBolt hBaseBolt = BaseHbasebolt.getHBaseBolt();
        builder.setBolt("base-hbase-bolt", hBaseBolt, 3).shuffleGrouping("hbase-bolt");

        Config conf = new Config();
        conf.setNumWorkers(4);
        conf.setNumAckers(0);
        conf.setDebug(false);
        //设置hbse的默认地址
        conf.put("hbase.conf", BaseHbasebolt.getHbaseConf());

        if (args != null && args.length > 0) {
            //提交topology到storm集群中运行
            StormSubmitter.submitTopology("kafka-storm-topology", conf, builder.createTopology());
        } else {
            //LocalCluster用来将topology提交到本地模拟器运行，方便开发调试
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("kafka-storm-topology", conf, builder.createTopology());
        }
    }
}
