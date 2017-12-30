package com.hdsx.car.service.strom.common;

import org.apache.storm.kafka.BrokerHosts;

import java.io.Serializable;
import java.util.List;

public class SpoutConfig extends KafkaConfig implements Serializable {

    /**
     * 记录Spout读取进度所用的zookeeper的host
     */
    public List<String> zkServers = null;

    /**
     * 记录进度用的zookeeper的端口
     */
    public Integer zkPort = null;

    /**
     * 进度信息记录于zookeeper的哪个路径下
     */
    public String zkRoot = null;

    /**
     * 进度记录的id，想要一个新的Spout读取之前的记录，应把它的id设为跟之前的一样。
     */
    public String id = null;

    /**
     * 用于metrics,多久更新一次状态。
     */
    public long stateUpdateIntervalMs = 2000;

    public SpoutConfig(BrokerHosts hosts, String topic, String zkRoot, String id) {
        super(hosts, topic);
        this.zkRoot = zkRoot;
        this.id = id;
    }
}