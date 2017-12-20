package com.hdsx.car.mq;


import com.hdsx.car.mq.histrix.RabbitMqServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-rabbit",fallback = RabbitMqServiceHystrix.class)
public interface RabbitMqService {
    /**
     * 发送tcp消息
     */
    @PostMapping("validate")
    void sendTCPValue(Object msgData);

    /**
     * 发送注册短消息
     */
    @PostMapping("validate")
    void sendValidate(Object msgData);

    /**
     * 现金通知
     */
    @PostMapping("notify")
    void sendCashNotify(Object msgData);
}
