package com.hdsx.car.car.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableHystrix
//@EnableApolloConfig
@SpringBootApplication(exclude = RabbitAutoConfiguration.class,scanBasePackages ={"com.hdsx"})
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.hdsx.car.redis","com.hdsx.car.car"})
@EnableEurekaClient
@MapperScan(basePackages = "com.hdsx.car.dao")
@ServletComponentScan
public class ServiceCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCarApplication.class, args);
	}

}
