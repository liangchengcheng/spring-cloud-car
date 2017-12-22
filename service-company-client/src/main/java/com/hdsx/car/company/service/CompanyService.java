package com.hdsx.car.company.service;

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
     * 查询企业集合
     */
    @RequestMapping(value = "/getCompanys",method = RequestMethod.GET)
    @ResponseBody
    Pagination getCompanys(
            @RequestParam("pageNo")        Integer pageNo,
            @RequestParam("pageSize")     Integer pageSize,
            @RequestParam("campanyName")       String campanyName,
            @RequestParam("registCity")       String registCity
    );

    /**
     * 新增企业信息
     */
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    boolean addCompany(@RequestBody CompanyVo companyVo);

    /**
     * 更新企业信息
     */
    @RequestMapping(value = "/updateCompany", method = RequestMethod.PUT)
    boolean updateCompany(@RequestBody CompanyVo companyVo);

    /**
     * 删除企业信息
     */
    @RequestMapping(value = "/deleteCompany", method = RequestMethod.DELETE)
    boolean deleteCompany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业信息详情
     */
    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    @ResponseBody
    CompanyVo getCompany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业是否存在
     */
    @RequestMapping(value = "/checkCompany", method = RequestMethod.GET)
    boolean checkCompany(@RequestParam("camSocietyId") String camSocietyId);

    @RequestMapping(value = "/getCompanyTree", method = RequestMethod.GET)
    List<Combotree> getCompanyTree();
}
