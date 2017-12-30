package com.hdsx.car.service.bus.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class KafkaSender {

    @Autowired
    private Source source;

    public void sendMessage(String message) {
        try {
            source.output1().send(MessageBuilder.withPayload("message: " + message).build());
        } catch (Exception e) {
            System.out.println("消息发送失败，原因："+e);
            e.printStackTrace();
        }
    }
}