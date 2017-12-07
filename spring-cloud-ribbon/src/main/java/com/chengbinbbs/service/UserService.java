package com.chengbinbbs.service;

import com.chengbinbbs.module.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 服务层
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 增加@HystrixCommand注解来指定回调方法
     */
    @HystrixCommand(fallbackMethod = "addUserFallback")
    public User addUser(String name,Integer age){
        String url = "http://user-service/user/add?name=" + name + "&age=" + age;
        return restTemplate.getForEntity(url,User.class).getBody();
    }

    /**
     * 回调函数,必须跟主函数参数、返回值保持一致，否则会报错
     */
    public User addUserFallback(String name,Integer age){
        return new User();
    }
}
