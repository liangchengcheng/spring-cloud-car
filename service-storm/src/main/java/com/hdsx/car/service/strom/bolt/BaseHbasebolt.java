package com.hdsx.car.service.strom.bolt;

import org.apache.storm.Config;
import org.apache.storm.hbase.bolt.HBaseBolt;
import org.apache.storm.hbase.bolt.mapper.SimpleHBaseMapper;
import org.apache.storm.tuple.Fields;

import java.util.HashMap;
import java.util.Map;

public class BaseHbasebolt {

    public static HBaseBolt getHBaseBolt() {
        SimpleHBaseMapper mapper = new SimpleHBaseMapper();

        //wordcount为表名
        HBaseBolt hBaseBolt = new HBaseBolt("wordcount", mapper).withConfigKey("hbase.conf");

        //result为列族名
        mapper.withColumnFamily("result");
        mapper.withColumnFields(new Fields("count"));
        mapper.withRowKeyField("word");
        return hBaseBolt;
    }

    public static Map<String, Object> getHbaseConf() {
        Map<String, Object> hbConf = new HashMap<String, Object>();
        hbConf.put("hbase.rootdir", "hdfs://127.0.0.1:9000/hbase");
        hbConf.put("hbase.zookeeper.quorum", "127.0.0.1:2181");
        return hbConf;
    }
}
