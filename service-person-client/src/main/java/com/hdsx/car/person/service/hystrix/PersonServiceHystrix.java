package com.hdsx.car.person.service.hystrix;

import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.CarInformation;
import com.hdsx.car.model.PersonVo;
import com.hdsx.car.person.service.PersonService;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceHystrix implements PersonService {

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

