package com.hdsx.car.dict.service;

import com.hdsx.car.dict.service.hystrix.DictServiceHystrix;
import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.CarInformation;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.DictValue;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ResponseBody  应不应该加呢？
 *
 * 枚举信息接口
 * FeignClient(value = "service-dict"?
 */

@FeignClient(value = "service-company",fallback = DictServiceHystrix.class)
public interface DictService {


    /**
     * 查询公司信息
     */
    @RequestMapping(value = "/getCompany",method = RequestMethod.GET)
    BaseResult getCompany();

    /**
     * 查询车辆信息
     */
    @RequestMapping(value = "/getDict",method = RequestMethod.GET)
    BaseResult getDict(
            @RequestParam("societyId") String societyId,
            @RequestParam("plateNumber") String plateNumber);

    /**
     * 查询字典信息
     */
    @RequestMapping(value = "/getCars", method = RequestMethod.PUT)
    BaseResult getCars( @RequestParam("mcode") String mcode,
                        @RequestParam("mtype") String mtype);

}
