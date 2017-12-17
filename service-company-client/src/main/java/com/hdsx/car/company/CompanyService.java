package com.hdsx.car.company;

import com.hdsx.car.company.hystrix.CartServiceHystrix;
import com.hdsx.car.model.Combotree;
import com.hdsx.car.model.CompanyVo;
import com.hdsx.car.model.Pagination;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ResponseBody  应不应该加呢？
 */

@FeignClient(value = "service-cart",fallback = CartServiceHystrix.class)
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
    @RequestMapping(value = "/addCampany",method = RequestMethod.POST)
    boolean addCompany(@RequestBody CompanyVo companyVo);

    /**
     * 更新企业信息
     */
    @RequestMapping(value = "/updateCampany", method = RequestMethod.PUT)
    boolean updateCampany(@RequestBody CompanyVo companyVo);

    /**
     * 删除企业信息
     */
    @RequestMapping(value = "/deleteCampany", method = RequestMethod.DELETE)
    boolean deleteCampany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业信息详情
     */
    @RequestMapping(value = "/getCampany", method = RequestMethod.GET)
    @ResponseBody
    CompanyVo getCampany(@RequestParam("camSocietyId") String camSocietyId);

    /**
     * 查询企业是否存在
     */
    @RequestMapping(value = "/checkCampany", method = RequestMethod.GET)
    boolean checkCampany(@RequestParam("camSocietyId") String camSocietyId);

    @RequestMapping(value = "/getCampanyTree", method = RequestMethod.GET)
    List<Combotree> getCampanyTree();
}
