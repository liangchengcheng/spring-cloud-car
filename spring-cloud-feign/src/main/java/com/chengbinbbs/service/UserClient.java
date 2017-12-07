package com.chengbinbbs.service;

import com.chengbinbbs.fallback.UserClientHystrix;
import com.chengbinbbs.module.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("user-service")
 * 注解来绑定该接口对应user-service服务
 * 这个地方是客户端消费者的负载均衡的地方。
 * 客户端 -> 负载均衡。
 * 为什么要卸载客服端的  服务层呢？
 */
@FeignClient(value = "user-service",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    User addUser(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age);
}
