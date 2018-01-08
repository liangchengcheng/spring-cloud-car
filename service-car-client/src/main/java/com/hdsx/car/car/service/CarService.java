package com.hdsx.car.car.service;

import com.hdsx.car.car.service.hystrix.CarServiceHystrix;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.CarInformation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ResponseBody  应不应该加呢？
 *
 * FeignClient(value = "service-company"?
 */

@FeignClient(value = "service-car",fallback = CarServiceHystrix.class)
public interface CarService {

    /**
     * 获取车辆信息
     */
    @RequestMapping(value = "/getCars",method = RequestMethod.GET)
    BaseResult getCars(@RequestParam("pageNo") int pageNo,
                       @RequestParam("pageSize") int pageSize,
                       @RequestParam("societyId") String societyId,
                       @RequestParam("plateNumber") String plateNumber,
                       @RequestParam("carType") String carType);

    /**
     * 添加车辆信息
     */
    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    BaseResult addCar(CarInformation car);

    /**
     * 修改车辆信息
     */
    @RequestMapping(value = "/updateCar",method = RequestMethod.PUT)
    BaseResult updateCar(CarInformation car);

    /**
     * 删除车辆信息
     */
    @RequestMapping(value = "/updateCar",method = RequestMethod.DELETE)
    BaseResult deleteCar(@RequestParam("plateNumber") String plateNumber);

    /**
     * 查询车辆信息
     */
    @RequestMapping(value = "/updateCar",method = RequestMethod.GET)
    BaseResult getCar(@RequestParam("plateNumber") String plateNumber);

}
