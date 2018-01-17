package com.hdsx.car.login.service.impl;

import com.hdsx.car.dao.LoginMapper;
import com.hdsx.car.login.service.LoginService;
import com.hdsx.car.model.*;
import com.hdsx.car.redis.RedisService;
import com.hdsx.car.utils.FastJsonConvert;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Transactional
@Api(value = "API - LoginServiceImpl", description = "公司企业信息基本 服务")
@RestController
@RefreshScope
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper mapper;

    @Autowired
    private RedisService redisService;

    @ApiOperation("用户web端登录的界面")
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
    public BaseResult login(@RequestBody User user) {
        BaseResult baseResult = new BaseResult();
        try {
            String userJson = redisService.get(user.getUsername());
            if (userJson != null) {
               return new BaseResult(200, "登录成功",FastJsonConvert.convertJSONToObject(userJson,User.class));
            }
            User userResult  = mapper.login(user);
            if (userResult != null) {
                baseResult = new BaseResult(200, "登录成功", userResult);
                redisService.set(user.getUsername(),FastJsonConvert.convertObjectToJSON(baseResult));
            } else {
                baseResult = new BaseResult(500, "用户不存在或者密码错误", "");
            }
        } catch (Exception e) {
            baseResult = new BaseResult(500, "服务器异常,请稍后再试", "");
            e.printStackTrace();
        }
        return baseResult;
    }


}
