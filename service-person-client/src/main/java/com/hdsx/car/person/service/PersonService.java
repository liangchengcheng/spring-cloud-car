package com.hdsx.car.person.service;

import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.CarInformation;
import com.hdsx.car.model.PersonVo;
import com.hdsx.car.person.service.hystrix.PersonServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ResponseBody  应不应该加呢？
 *
 * FeignClient(value = "service-company"?
 */

@FeignClient(value = "service-person",fallback = PersonServiceHystrix.class)
public interface PersonService {

    /**
     * 查询人员集合
     */
    @RequestMapping(value = "/getCars",method = RequestMethod.GET)
    BaseResult getPersons(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber);

    /**
     * 新增人员信息
     */
    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    BaseResult addPerson(PersonVo personVo);

    /**
     * 更新人员信息
     */
    @RequestMapping(value = "/updateCar",method = RequestMethod.PUT)
    BaseResult updateCar(PersonVo personVo);

    /**
     * 删除人员信息
     */
    @RequestMapping(value = "/deletePerson",method = RequestMethod.DELETE)
    BaseResult deletePerson(
            @RequestParam("IDCardType") String IDCardType,
            @RequestParam("IDCardType") String IDCardNumber);

    /**
     * 查询人员信息
     */
    @RequestMapping(value = "/updateCar",method = RequestMethod.GET)
    BaseResult getPerson(
            @RequestParam("IDCardType") String IDCardType,
            @RequestParam("IDCardType") String IDCardNumber
    );

}
