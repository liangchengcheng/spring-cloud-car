package com.hdsx.car.dao;

import com.hdsx.car.model.CompanyRegist;
import com.hdsx.car.model.User;

import java.util.List;

/**
 * 登录的dao层的到吗
 */
public interface LoginMapper {

    User login(User user);
}
