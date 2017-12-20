package com.hdsx.car.mq.histrix;

import com.hdsx.car.mq.RabbitMqService;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqServiceHystrix implements RabbitMqService {

    @Override
    public void sendTCPValue(Object msgData) {

    }

    @Override
    public void sendValidate(Object msgData) {

    }

    @Override
    public void sendCashNotify(Object msgData) {

    }
}
