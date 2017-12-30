package com.hdsx.car.service.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {

    @KafkaListener(topics = {"mytopic","mytopic1"})
    public void processMessage(String content) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$" + content);
    }

}
