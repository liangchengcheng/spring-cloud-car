package com.hdsx.car.dict.service.impl;

import com.hdsx.car.dao.DictMapper;
import com.hdsx.car.dict.service.DictService;
import com.hdsx.car.model.*;
import com.hdsx.car.redis.RedisService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//@Transactional
@Api(value = "API - CarServiceImpl", description = "车辆信息基本 服务")
@RestController
@RefreshScope
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper mapper;

    @Autowired
    private RedisService redisService;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ApiOperation("查询公司信息")

    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public BaseResult getCompany() {
        List<DictValue> list = new ArrayList<DictValue>();
        List<CompanyRegist> companyRegistList = mapper.getCampany();
        for (CompanyRegist bean : companyRegistList) {
            DictValue dict = new DictValue();
            dict.setMcode(bean.getSocietyId());
            dict.setMvalue(bean.getCampanyName());
            list.add(dict);
        }
        BaseResult baseResult = new BaseResult(200, "ok", list);
        return baseResult;
    }

    @Override
    @ApiOperation(value = "查询车辆信息-传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "societyId", dataType = "String", value = "企业Id"),
                    @ApiImplicitParam(paramType = "query", name = "plateNumber", dataType = "String", value = "车牌号")
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
    public BaseResult getCars(String societyId,String plateNumber) {
        List<DictValue> list = new ArrayList<DictValue>();
        CarInformation carInformation = new CarInformation();
        carInformation.setSocietyId(societyId);
        carInformation.setPlateNumber(plateNumber);
        List<CarInformation> cars = mapper.getCars(carInformation);
        for (CarInformation bean : cars) {
            DictValue dict = new DictValue();
            dict.setMcode(bean.getPlateNumber());
            dict.setMvalue(bean.getPlateNumber());
            list.add(dict);
        }
        BaseResult baseResult = new BaseResult(200, "ok", list);
        return baseResult;
    }

    @ApiOperation("查询字典信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "mcode", dataType = "String", value = "枚举编码" ),
                    @ApiImplicitParam(paramType = "query", name = "mtype", dataType = "String", value = "枚举类型" ),            }
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
    public BaseResult getDict(String mcode,String mtype) {
        DictValue dictValue = new DictValue();
        dictValue.setMcode(mcode);
        dictValue.setMtype(mtype);
        List<DictValue> dict = mapper.getDict(dictValue);
        BaseResult baseResult = new BaseResult(200, "ok", dict);
        return baseResult;
    }

}
