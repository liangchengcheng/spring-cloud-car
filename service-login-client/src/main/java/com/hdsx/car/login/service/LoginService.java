package com.hdsx.car.login.service;

import com.hdsx.car.login.service.hystrix.LoginServiceHystrix;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ResponseBody  应不应该加呢？
 *
 * 登录的接口
 * FeignClient(value = "service-dict"?
 */

@FeignClient(value = "service-login",fallback = LoginServiceHystrix.class)
public interface LoginService {

    /**
     * 登录的接口
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    BaseResult login(User user);


}
