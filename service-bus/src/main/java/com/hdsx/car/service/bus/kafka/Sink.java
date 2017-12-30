package com.hdsx.car.service.bus.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    //接收队列1
    String INPUT_1 = "testa";

    @Input(Sink.INPUT_1)
    SubscribableChannel input1();

}