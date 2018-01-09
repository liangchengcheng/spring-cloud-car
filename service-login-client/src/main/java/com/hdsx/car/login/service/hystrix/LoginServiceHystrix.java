package com.hdsx.car.login.service.hystrix;

import com.hdsx.car.login.service.LoginService;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.User;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceHystrix implements LoginService {

    @Override
    public BaseResult login(User user) {
        return null;
    }
}

