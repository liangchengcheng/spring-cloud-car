package com.hdsx.car.dao;

import com.hdsx.car.model.CarInformation;
import com.hdsx.car.model.CompanyRegist;
import com.hdsx.car.model.DictValue;

import java.util.List;

public interface DictMapper {


    List<CompanyRegist> getCampany();

    List<DictValue> getDict(DictValue dictType);

    List<CarInformation> getCars(CarInformation carInformation);

}
