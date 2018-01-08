package com.hdsx.car.car.service.hystrix;

import com.hdsx.car.car.service.CarService;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.CarInformation;
import org.springframework.stereotype.Component;

@Component
public class CarServiceHystrix implements CarService {

    @Override
    public BaseResult getCars(int pageNo, int pageSize, String societyId, String plateNumber, String carType) {
        return null;
    }

    @Override
    public BaseResult addCar(CarInformation car) {
        return null;
    }

    @Override
    public BaseResult updateCar(CarInformation car) {
        return null;
    }

    @Override
    public BaseResult deleteCar(String plateNumber) {
        return null;
    }

    @Override
    public BaseResult getCar(String plateNumber) {
        return null;
    }
}

