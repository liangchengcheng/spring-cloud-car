package com.hdsx.car.dao;

import com.hdsx.car.model.CarInformation;
import com.hdsx.car.model.QueryBean;

import java.util.List;

public interface CarMapper {

    List<CarInformation> getList(QueryBean queryBean);

    int getTotal(QueryBean queryBean);

    int addCar(CarInformation car);

    int updateCar(CarInformation car);

    int deleteCar(String plateNumber);

    CarInformation getCarInformation(String plateNumber);
}
