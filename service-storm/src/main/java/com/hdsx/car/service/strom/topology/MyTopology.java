package com.hdsx.car.service.strom.topology;

import com.hdsx.car.service.strom.bolt.FluxBolt;
import com.hdsx.car.service.strom.bolt.ParseBolt;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class MyTopology {
    public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException, InterruptedException, AuthorizationException {
        String topic = "mytopic";
        String zkRoot = "/kafka-storm";
        String id = "kafka-storm";
        //BrokerHosts brokerHosts = new ZkHosts("127.0.0.1:2181,h41:2181,h42:2181","/kafka/brokers");
        BrokerHosts brokerHosts = new ZkHosts("127.0.0.1:2181","/kafka/brokers");
        //配置kafka时，如果使用zookeeper create /kafka创建了节点，
        // kafka与storm集成时new ZkHosts(zks) 需要改成 new ZkHosts(zks,”/kafka/brokers”),
        // 不然会报  java.lang.RuntimeException: java.lang.RuntimeException: org.apache.zookeeper.KeeperException$NoNodeException:
        // KeeperErrorCode = NoNode for /brokers/topics/test/partitions
        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, topic, zkRoot, id);
        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        TopologyBuilder builder = new TopologyBuilder();

        //设置一个spout用来从kaflka消息队列中读取数据并发送给下一级的bolt组件，此处用的spout组件并非自定义的，而是storm中已经开发好的KafkaSpout
        builder.setSpout("KafkaSpout", new KafkaSpout(spoutConfig));
        builder.setBolt("parse-bolt", new ParseBolt()).shuffleGrouping("KafkaSpout");
        builder.setBolt("writer", new FluxBolt(), 3).fieldsGrouping("word-spilter", new Fields("word"));

        Config conf = new Config();
        conf.setNumWorkers(4);
        conf.setNumAckers(0);
        conf.setDebug(false);

        if (args != null && args.length > 0) {
            //提交topology到storm集群中运行
            StormSubmitter.submitTopology("sufei-topo", conf, builder.createTopology());
        } else {
            //LocalCluster用来将topology提交到本地模拟器运行，方便开发调试
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("WordCount", conf, builder.createTopology());
        }
    }
}
