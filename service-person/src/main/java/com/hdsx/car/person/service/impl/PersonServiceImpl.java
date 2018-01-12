package com.hdsx.car.person.service.impl;

import com.hdsx.car.dao.PersonMapper;
import com.hdsx.car.model.*;
import com.hdsx.car.person.service.PersonService;
import com.hdsx.car.redis.RedisService;
import com.hdsx.car.utils.DateFormatUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

//@Transactional
@Api(value = "API - CompanyServiceImpl", description = "公司企业信息基本 服务")
@RestController
@RefreshScope
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private RedisService redisService;

    @Override
    @ApiOperation(value = "查询人员集合-传递简单对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "当前页数", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页显示行数", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "string", value = "驾驶员姓名"),
            @ApiImplicitParam(paramType = "query", name = "phoneNumber", dataType = "string", value = "驾驶员手机号")
    })
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getPersons(int pageNo, int pageSize, String name, String phoneNumber) {
        QueryBean queryBean = new QueryBean();
        queryBean.setPagination(new Pagination(pageNo, pageSize));
        PersonInformation personInformation = new PersonInformation();
        personInformation.setName(name);
        personInformation.setPhoneNumber(phoneNumber);
        queryBean.setPerson(personInformation);

        Pagination pagination = new Pagination();
        int total = mapper.getTotal(queryBean);
        pagination.setTotalCount(total);
        List<PersonInformation> list = mapper.getList(queryBean);
        pagination.setList(list);

        BaseResult baseResult = new BaseResult(200, "ok", pagination);
        return baseResult;
    }

    @Override
    @ApiOperation(value = "新增人员信息-传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "PersonVo",
                            name = "personVo",
                            value = "信息参数",
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
    public BaseResult addPerson(@RequestBody PersonVo personVo) {
        BaseResult baseResult;
        PersonInformation information = personVo.getPersonInformation();
        PersonQualification qualification = personVo.getPersonQualification();
        PersonEducation education = personVo.getPersonEducation();
        information.setBirthDate(DateFormatUtil.dateFormat(information.getBirthDate()));
        information.setUpdateTime(DateFormatUtil.dateFormat(new Date()));
        qualification.setCertificateExpireDate(DateFormatUtil.dateFormat(qualification.getCertificateExpireDate()));
        qualification.setCarCertificateAssessDate(DateFormatUtil.dateFormat(qualification.getCarCertificateAssessDate()));
        qualification.setCarCertificateExpireDate(DateFormatUtil.dateFormat(qualification.getCarCertificateExpireDate()));
        qualification.setUpdateTime(DateFormatUtil.dateFormat(qualification.getUpdateTime()));
        int result1 = mapper.addPersonInformation(information);
        int result2 = mapper.addPersonQualification(qualification);
        int result3 = mapper.addPersonEducation(education);
        if (result1 > 0 && result2 > 0 && result3 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }
        return baseResult;
    }

    @Override
    @ApiOperation(value = "更新人员信息-传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "PersonVo",
                            name = "personVo",
                            value = "信息参数",
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
    public BaseResult updatePerson(PersonVo personVo) {
        BaseResult baseResult;
        PersonInformation information = personVo.getPersonInformation();
        PersonQualification qualification = personVo.getPersonQualification();
        PersonEducation education = personVo.getPersonEducation();
        information.setBirthDate(DateFormatUtil.dateFormat(information.getBirthDate()));
        information.setUpdateTime(DateFormatUtil.dateFormat(new Date()));
        qualification.setCertificateExpireDate(DateFormatUtil.dateFormat(qualification.getCertificateExpireDate()));
        qualification.setCarCertificateAssessDate(DateFormatUtil.dateFormat(qualification.getCarCertificateAssessDate()));
        qualification.setCarCertificateExpireDate(DateFormatUtil.dateFormat(qualification.getCarCertificateExpireDate()));
        qualification.setUpdateTime(DateFormatUtil.dateFormat(qualification.getUpdateTime()));
        int result1 = mapper.updatePersonInformation(information);
        int result2 = mapper.updatePersonQualification(qualification);
        int result3 = mapper.updatePersonEducation(education);
        if (result1 > 0 && result2 > 0 && result3 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }
        return baseResult;
    }

    @Override
    @ApiOperation(value = "删除人员信息-传递简单对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "IDCardType", dataType = "String", value = "证件类型",required=true),
            @ApiImplicitParam(paramType = "query", name = "IDCardNumber", dataType = "String", value = "证件号码",required=true)
    })
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult deletePerson(String IDCardType, String IDCardNumber) {
        BaseResult baseResult;
        PersonInformation personInformation = new PersonInformation();
        personInformation.setIDCardType(IDCardType);
        personInformation.setIDCardNumber(IDCardNumber);
        int result1 = mapper.deletePersonInformation(personInformation);
        int result2 = mapper.deletePersonQualification(personInformation);
        int result3 = mapper.deletePersonEducation(personInformation);
        if (result1 > 0 && result2 > 0 && result3 > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }
        return baseResult;
    }

    @Override
    @ApiOperation(value = "查询人员信息-传递简单对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "IDCardType", dataType = "String", value = "证件类型",required=true),
            @ApiImplicitParam(paramType = "query", name = "IDCardNumber", dataType = "String", value = "证件号码",required=true)
    })
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getPerson(String IDCardType, String IDCardNumber) {
        PersonInformation personInformation = new PersonInformation();
        personInformation.setIDCardType(IDCardType);
        personInformation.setIDCardNumber(IDCardNumber);

        PersonQualification personQualification = mapper.getPersonQualification(personInformation);
        PersonEducation personEducation = mapper.getPersonEducation(personInformation);
        PersonVo personVo =  new PersonVo(personInformation, personQualification, personEducation);

        BaseResult baseResult = new BaseResult(500, "no", personVo);
        return baseResult;
    }
}
