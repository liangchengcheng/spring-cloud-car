package com.hdsx.rabbitmq.service.impl;

import com.hdsx.car.mq.RabbitMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqServiceImpl implements RabbitMqService{

    @Autowired
    private RabbitTemplate rabbitSmsTemplate;

    @Override
    public void sendTCPValue(Object msgData) {
        rabbitSmsTemplate.convertAndSend(EXCHANGE, VALIDATE, data);
    }

    @Override
    public void sendValidate(Object msgData) {
        rabbitSmsTemplate.convertAndSend(EXCHANGE, VALIDATE, data);
    }

    @Override
    public void sendCashNotify(Object msgData) {
        rabbitSmsTemplate.convertAndSend(EXCHANGE, VALIDATE, data);
    }
}
