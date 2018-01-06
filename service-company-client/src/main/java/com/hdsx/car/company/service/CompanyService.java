package com.hdsx.car.company.service;

import com.hdsx.car.model.BaseResult;
import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.Pagination;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.hdsx.car.company.service.hystrix.CompanyServiceHystrix;
import java.util.List;

/**
 * @ResponseBody  应不应该加呢？
 *
 * FeignClient(value = "service-company"?
 */

@FeignClient(value = "service-company",fallback = CompanyServiceHystrix.class)
public interface CompanyService {


    /**
     * 新增企业信息
     */
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    BaseResult addCompany(CompanyVo companyVo);


    /**
     * 查询企业集合
     */
    @RequestMapping(value = "/getCompanyList",method = RequestMethod.GET)
    @ResponseBody
    BaseResult getCompanyList(
            @RequestParam("pageNo")            Integer pageNo,
            @RequestParam("pageSize")          Integer pageSize,
            @RequestParam("companyName")       String campanyName,
            @RequestParam("registCity")        String registCity
    );

    /**
     * 更新企业信息
     */
    @RequestMapping(value = "/updateCompany", method = RequestMethod.PUT)
    BaseResult updateCompany(CompanyVo companyVo);

    /**
     * 删除企业信息
     */
    @RequestMapping(value = "/deleteCompany", method = RequestMethod.DELETE)
    BaseResult deleteCompany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业信息详情
     */
    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    @ResponseBody
    BaseResult getCompany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业是否存在
     */
    @RequestMapping(value = "/checkCompany", method = RequestMethod.GET)
    BaseResult checkCompany(@RequestParam("camSocietyId") String camSocietyId);

    @RequestMapping(value = "/getCompanyTree", method = RequestMethod.GET)
    BaseResult getCompanyTree();
}
