package com.hdsx.car.service.strom.common;

import org.apache.storm.kafka.BrokerHosts;
import org.apache.storm.spout.MultiScheme;
import org.apache.storm.spout.RawMultiScheme;

import java.io.Serializable;

public class KafkaConfig implements Serializable {
    /**
     * 用以获取Kafka broker和partition的信息
     */
    public final BrokerHosts hosts;

    /**
     * 从哪个topic读取消息
     */
    public final String topic;

    /**
     * SimpleConsumer所用的client id
     */
    public final String clientId;

    /**
     * 发给Kafka的每个FetchRequest中，用此指定想要的response中总的消息的大小
     */
    public int fetchSizeBytes = 1024 * 1024;

    /**
     * 与Kafka broker的连接的socket超时时间
     */
    public int socketTimeoutMs = 10000;

    /**
     * 当服务器没有新消息时，消费者会等待这些时间
     */
    public int fetchMaxWait = 10000;

    /**
     * SimpleConsumer所使用的SocketChannel的读缓冲区大小
     */
    public int bufferSizeBytes = 1024 * 1024;

    /**
     * 从Kafka中取出的byte[]，该如何反序列化
     */
    public MultiScheme scheme = new RawMultiScheme();

    /**
     * 是否强制从Kafka中offset最小的开始读起
     */
    public boolean forceFromStart = false;//

    /**
     * 从何时的offset时间开始读，默认为最旧的offset
     */
    public long startOffsetTime = kafka.api.OffsetRequest.EarliestTime();

    /**
     * KafkaSpout读取的进度与目标进度相差多少，相差太多，Spout会丢弃中间的消息
     */
    public long maxOffsetBehind = 100000;

    /**
     * 如果所请求的offset对应的消息在Kafka中不存在，是否使用startOffsetTime
     */
    public boolean useStartOffsetTimeIfOffsetOutOfRange = true;

    /**
     * 多长时间统计一次metrics
     */
    public int metricsTimeBucketSizeInSecs = 60;

    public KafkaConfig(BrokerHosts hosts, String topic) {
        this(hosts, topic, kafka.api.OffsetRequest.DefaultClientId());
    }

    public KafkaConfig(BrokerHosts hosts, String topic, String clientId) {
        this.hosts = hosts;
        this.topic = topic;
        this.clientId = clientId;
    }

}
