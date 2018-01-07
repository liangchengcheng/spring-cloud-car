package com.hdsx.car.company.service.impl;

import com.hdsx.car.company.service.CompanyService;
import com.hdsx.car.dao.CompanyMapper;
import com.hdsx.car.model.*;
import com.hdsx.car.redis.RedisService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

//@Transactional
@Api(value = "API - CompanyServiceImpl", description = "公司企业信息基本 服务")
@RestController
@RefreshScope
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper mapper;

    @Autowired
    private RedisService redisService;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ApiOperation("获取企业基本信息列表")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNo", value = "", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "companyName", value = "", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "registCity", value = "", required = true, dataType = "String", paramType = "query")
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getCompanyList(int pageNo, int pageSize, String companyName, String registCity) {
        QueryBean queryBean = new QueryBean();
        queryBean.setPagination(new Pagination(pageNo, pageSize));

        //封装企业信息
        CompanyRegist company = new CompanyRegist();
        company.setCampanyName(companyName);
        company.setRegistCity(registCity);
        queryBean.setCampany(company);

        Pagination pagination = new Pagination();
        int total = mapper.getTotal(queryBean);
        pagination.setTotalCount(total);
        List<CompanyRegist> list = mapper.getList(queryBean);
        pagination.setList(list);
        BaseResult baseResult = new BaseResult(200, "ok", pagination);
        return baseResult;
    }

    @Override
    @ApiOperation(value = "添加企业信息-传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "CompanyVo",
                            name = "companyVo",
                            value = "添加信息参数",
                            required = true)
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult addCompany(@RequestBody CompanyVo companyVo) {

        int result = 0;
        int result2 = 0;
        try {
            //获取注册信息
            CompanyRegist companyRegist = companyVo.getCampanyRegist();
            String updateTime = dateFormat.format(new Date());
            companyRegist.setUpdateTime(updateTime);
            companyRegist.setRegistTime(dateFormat.format(dateFormat.parse(companyRegist.getRegistTime())));

            //获取合格证书
            CompanyQualification campanyQualification = companyVo.getCampanyQualification();
            campanyQualification.setUpdateTime(updateTime);
            campanyQualification.setQualificationAssessDate(
                    dateFormat.format(dateFormat.parse(campanyQualification.getQualificationAssessDate())));
            campanyQualification.setQualificationExpireDate(
                    dateFormat.format(dateFormat.parse(campanyQualification.getQualificationExpireDate())));
            campanyQualification
                    .setConferTime(dateFormat.format(dateFormat.parse(campanyQualification.getConferTime())));
            //添加注册信息
            result = mapper.addCampanyRegist(companyRegist);
            //添加合格证书信息
            result2 = mapper.addCampanyQualification(campanyQualification);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BaseResult baseResult;
        if (result > 0 && result2 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }

        return baseResult;
    }


    @ApiOperation(value = "修改企业信息-传递简单对象", notes = "传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "CompanyVo",
                            name = "companyVo",
                            value = "修改信息参数",
                            required = true)
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult updateCompany(@RequestBody CompanyVo companyVo) {

        int result = 0;
        int result2 = 0;
        try {

            CompanyRegist companyRegist = companyVo.getCampanyRegist();
            String updateTime = dateFormat.format(new Date());
            companyRegist.setUpdateTime(updateTime);
            companyRegist.setRegistTime(dateFormat.format(companyRegist.getRegistTime()));
            result = mapper.updateCampanyRegist(companyRegist);


            CompanyQualification campanyQualification = companyVo.getCampanyQualification();
            campanyQualification.setUpdateTime(updateTime);
            campanyQualification.setQualificationAssessDate(
                    dateFormat.format(dateFormat.parse(campanyQualification.getQualificationAssessDate())));
            campanyQualification.setQualificationExpireDate(
                    dateFormat.format(dateFormat.parse(campanyQualification.getQualificationExpireDate())));
            campanyQualification
                    .setConferTime(dateFormat.format(dateFormat.parse(campanyQualification.getConferTime())));
            result2 = mapper.updateCampanyQualification(campanyQualification);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BaseResult baseResult;
        if (result > 0 && result2 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }

        return baseResult;
    }

    @ApiOperation("删除企业基本信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "camSocietyId", value = "", required = true, dataType = "String", paramType = "query")
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult deleteCompany(String camSocietyId) {
        int result = mapper.deleteCampanyRegist(camSocietyId);
        int result2 = mapper.deleteCampanyQualification(camSocietyId);
        BaseResult baseResult;
        if (result > 0 && result2 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }

        return baseResult;
    }

    @ApiOperation("获取企业基本信息详情")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "camSocietyId", value = "", required = true, dataType = "String", paramType = "query")
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getCompany(String camSocietyId) {
        CompanyRegist campanyRegist = mapper.getCampanyRegist(camSocietyId);
        CompanyQualification campanyQualification = mapper.getCampanyQualification(camSocietyId);
        CompanyVo companyVo = new CompanyVo(campanyRegist, campanyQualification);
        BaseResult baseResult = new BaseResult(200, "ok", companyVo);
        return baseResult;
    }


    @ApiOperation("检测企业是否存在")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "camSocietyId", value = "", required = true, dataType = "String", paramType = "query")
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult checkCompany(String camSocietyId) {
        CompanyRegist campanyRegist = mapper.getCampanyRegist(camSocietyId);
        CompanyQualification campanyQualification = mapper.getCampanyQualification(camSocietyId);
        BaseResult baseResult;
        if (campanyRegist != null && !"".equals(campanyRegist) &&
                campanyQualification != null && !"".equals(campanyQualification)) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }

        return baseResult;
    }

    @Override
    @ApiOperation("获取树")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getCompanyTree() {
        List<Combotree> combotreeList = mapper.getCampanyTree();
        BaseResult baseResult = new BaseResult(200, "ok", combotreeList);
        return baseResult;
    }
}
