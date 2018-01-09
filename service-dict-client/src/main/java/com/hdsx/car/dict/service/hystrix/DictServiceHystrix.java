package com.hdsx.car.dict.service.hystrix;

import com.hdsx.car.dict.service.DictService;
import com.hdsx.car.model.BaseResult;
import org.springframework.stereotype.Component;

@Component
public class DictServiceHystrix implements DictService {

    @Override
    public BaseResult getCompany() {
        return null;
    }

    @Override
    public BaseResult getDict(String societyId, String plateNumber) {
        return null;
    }

    @Override
    public BaseResult getCars(String mcode, String mtype) {
        return null;
    }
}

