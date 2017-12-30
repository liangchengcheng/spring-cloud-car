package com.hdsx.car.service.strom.spout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.hdsx.car.service.strom.common.SpoutConfig;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

/**
 * KafkaSpout
 */
public class KafkaSpout implements IRichSpout {
    private SpoutConfig _spoutConfig;
    private SpoutOutputCollector collector;
    private ConsumerConnector consumer;

    public KafkaSpout(SpoutConfig spoutConf) {
        _spoutConfig = spoutConf;
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {
        consumer =kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());

        Map<String,Integer> topickMap = new HashMap<String, Integer>();
        topickMap.put(_spoutConfig.topic, 1);

        System.out.println("*********Results********topic:"+_spoutConfig.topic);

        Map<String, List<KafkaStream<byte[],byte[]>>>  streamMap=consumer.createMessageStreams(topickMap);
        KafkaStream<byte[],byte[]>stream = streamMap.get(_spoutConfig.topic).get(0);
        ConsumerIterator<byte[],byte[]> it =stream.iterator();
        while(it.hasNext()){
            String value =new String(it.next().message());
            SimpleDateFormat formatter = new SimpleDateFormat   ("yyyy年MM月dd日 HH:mm:ss SSS");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String str = formatter.format(curDate);
            System.out.println("storm接收到来自kafka的消息------->" + value);
            collector.emit(new Values(value,1,str), value);
        }
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        // 设置zookeeper的链接地址
        props.put("zookeeper.connect","m1:2181,m2:2181,s1:2181,s2:2181");
        // 设置group id
        props.put("group.id", "1");
        // kafka的group 消费记录是保存在zookeeper上的, 但这个信息在zookeeper上不是实时更新的, 需要有个间隔时间更新
        props.put("auto.commit.interval.ms", "1000");
        props.put("zookeeper.session.timeout.ms","10000");
        return new ConsumerConfig(props);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void nextTuple() {

    }

    @Override
    public void ack(Object o) {

    }

    @Override
    public void fail(Object o) {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word","id","time"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
