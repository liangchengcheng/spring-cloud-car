package com.hdsx.car.service.bus.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(Sink.class)
public class KafkaReceiver {

    @StreamListener(Sink.INPUT_1)
    private void receive(String vote) {
        //logger.info("receive message : " + vote);
    }

}