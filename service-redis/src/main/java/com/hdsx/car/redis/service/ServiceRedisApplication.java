package com.hdsx.car.redis.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(exclude = RabbitAutoConfiguration.class,scanBasePackages ={"com.colossus"})
@EnableDiscoveryClient
@EnableHystrix
public class ServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRedisApplication.class,args);
    }
}
