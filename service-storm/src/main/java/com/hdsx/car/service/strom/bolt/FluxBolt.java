package com.hdsx.car.service.strom.bolt;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * 将接受的808协议的消息封装一下
 * 2：分发 （轨迹信息存hbase  其他的少的信息进入mysql和redis）
 */
@SuppressWarnings("serial")
public class FluxBolt extends BaseBasicBolt {

    private OutputCollector outputCollector;

    /**
     * bolt初始化方法
     */
    @SuppressWarnings("rawtypes")
    public void prepare(Map stormConf, TopologyContext context,
                        OutputCollector collector) {
        outputCollector = collector;
    }

    /**
     * 执行订阅的Tuple逻辑过程的方法
     */
    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String sentence = tuple.getString(0);
        String[] words = sentence.split(" ");
        // TODO: 2017/12/30 生成具体的message bean;
        for (String word : words) {
            outputCollector.emit(new Values(word));
        }
    }

    public void cleanup() {
    }

    /**
     * 字段声明
     */
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
