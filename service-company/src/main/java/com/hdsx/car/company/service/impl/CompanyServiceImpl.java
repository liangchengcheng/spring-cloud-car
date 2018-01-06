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
import java.util.List;

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
                    @ApiImplicitParam(name = "pageNo", value = "", required = true, dataType = "Integer"),
                    @ApiImplicitParam(name = "pageSize", value = "", required = true, dataType = "Integer"),
                    @ApiImplicitParam(name = "companyName", value = "", required = true, dataType = "Integer"),
                    @ApiImplicitParam(name = "registCity", value = "", required = true, dataType = "Integer")
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
    public BaseResult getCompanyList(Integer pageNo, Integer pageSize, String companyName, String registCity) {
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
        BaseResult baseResult = new BaseResult(200,"ok",pagination);
        return baseResult;
    }

    @Override
    @ApiOperation(value="添加企业信息-传递简单对象")
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
        return null;
    }


    @ApiOperation(value="修改企业信息-传递简单对象", notes="传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "CompanyVo",
                            name = "CompanyVo",
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
    public BaseResult updateCompany(CompanyVo companyVo) {
        return null;
    }

    @ApiOperation("删除企业基本信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "camSocietyId", value = "", required = true, dataType = "String")
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
        return null;
    }

    @ApiOperation("获取企业基本信息详情")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "camSocietyId", value = "", required = true, dataType = "String")
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
        return null;
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
        return null;
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
        List<Combotree> combotreeList = new ArrayList<>();
        return null;
    }
}
