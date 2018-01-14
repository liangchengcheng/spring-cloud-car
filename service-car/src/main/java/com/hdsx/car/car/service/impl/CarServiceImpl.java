package com.hdsx.car.car.service.impl;

import com.hdsx.car.car.service.CarService;
import com.hdsx.car.dao.CarMapper;
import com.hdsx.car.model.*;
import com.hdsx.car.redis.RedisService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

//@Transactional
@Api(value = "API - CarServiceImpl", description = "车辆信息基本 服务")
@RestController
@RefreshScope
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper mapper;

    @Autowired
    private RedisService redisService;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ApiOperation("查询车辆集合")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNo", value = "", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "societyId", value = "", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "plateNumber", value = "", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "carType", value = "", required = true, dataType = "String", paramType = "query")
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
    public BaseResult getCars(int pageNo,int pageSize,String societyId,String plateNumber,String carType) {
        QueryBean queryBean = new QueryBean();
        queryBean.setPagination(new Pagination(pageNo, pageSize));

        //1: 封装企业信息
        CompanyRegist campanyRegist = new CompanyRegist();
        campanyRegist.setSocietyId(societyId);
        queryBean.setCampany(campanyRegist);

        //2: 封装车辆信息
        CarInformation carInformation = new CarInformation();
        carInformation.setPlateNumber(plateNumber);
        carInformation.setCarType(carType);
        queryBean.setCar(carInformation);

        Pagination pagination = new Pagination();
        int total = mapper.getTotal(queryBean);
        pagination.setTotalCount(total);
        List<CarInformation> list = mapper.getList(queryBean);
        pagination.setList(list);

        BaseResult baseResult = new BaseResult(200, "ok", pagination);
        return baseResult;
    }

    @Override
    @ApiOperation(value = "新增车辆信息-传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "CarInformation",
                            name = "car",
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
    public BaseResult addCar(@RequestBody CarInformation car) {
        int result = mapper.addCar(car);
        BaseResult baseResult;
        if (result > 0 ) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }

        return baseResult;
    }


    @ApiOperation(value = "修改车辆信息-传递简单对象", notes = "传递简单对象")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            dataType = "CarInformation",
                            name = "car",
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
    public BaseResult updateCar(@RequestBody CarInformation car) {
        int result = mapper.updateCar(car);
        BaseResult baseResult;
        if (result > 0 ) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }
        return baseResult;
    }

    @ApiOperation("删除车辆信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "plateNumber", value = "", required = true, dataType = "String", paramType = "query")
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
    public BaseResult deleteCar(String plateNumber) {
        int result = mapper.deleteCar(plateNumber);
        BaseResult baseResult;
        if (result > 0) {
            baseResult = new BaseResult(200, "ok", "");
        } else {
            baseResult = new BaseResult(500, "no", "");
        }
        return baseResult;
    }

    @ApiOperation("查询车辆信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "plateNumber", value = "", required = true, dataType = "String", paramType = "query")
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
    public BaseResult getCar(String plateNumber) {
        CarInformation carInformation = mapper.getCarInformation(plateNumber);
        BaseResult baseResult = new BaseResult(200, "ok", carInformation);
        return baseResult;
    }
}
