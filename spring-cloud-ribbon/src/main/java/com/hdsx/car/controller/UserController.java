package com.hdsx.car.controller;

import com.hdsx.car.module.User;
import com.hdsx.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器  这里是对外的。
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public User addUser(@RequestParam(value = "name")String name, @RequestParam(value = "age")Integer age){
        return userService.addUser(name,age);
    }
}
