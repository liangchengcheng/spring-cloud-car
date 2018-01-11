package com.hdsx.car.person.service.impl;

import com.hdsx.car.dao.PersonMapper;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.PersonVo;
import com.hdsx.car.person.service.PersonService;
import com.hdsx.car.redis.RedisService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

//@Transactional
@Api(value = "API - CompanyServiceImpl", description = "公司企业信息基本 服务")
@RestController
@RefreshScope
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private RedisService redisService;

    @Override
    public BaseResult getPersons(int pageNo, int pageSize, String name, String phoneNumber) {
        return null;
    }

    @Override
    public BaseResult addPerson(PersonVo personVo) {
        return null;
    }

    @Override
    public BaseResult updatePerson(PersonVo personVo) {
        return null;
    }

    @Override
    public BaseResult deletePerson(String IDCardType, String IDCardNumber) {
        return null;
    }

    @Override
    public BaseResult getPerson(String IDCardType, String IDCardNumber) {
        return null;
    }
}
