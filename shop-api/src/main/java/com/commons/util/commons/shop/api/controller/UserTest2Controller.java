package com.commons.util.commons.shop.api.controller;


import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.base.util.IpUtils;
import com.commons.util.commons.shop.api.entity.User;
import com.commons.util.commons.shop.api.feign.OosServices;
import com.commons.util.commons.shop.api.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cxk
 * @since 2021-01-07
 */
@RestController
@Slf4j
@RequestMapping("/userTest")
public class UserTest2Controller {
    @Autowired
    IUserService userService;

    @GetMapping("getUserList")
    public R getUserList(HttpServletRequest request) {
        String realIpAddress = IpUtils.getRealIpAddress(request);
        List<User> users= userService.list();
        log.error(realIpAddress);
      return R.success(users);
    }
    @Autowired
    private OosServices oosServices;
    @ApiOperation(value = "测试多数据源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "test1的id", paramType = "query", required = true),
            @ApiImplicitParam(name = "testId", value = "test2的id，", paramType = "query", required = true),
    })
    @RequestMapping(value = "/ds", method = GET)
    public List<Instance> ds( String id,String testId) throws NacosException {



        User user1=userService.getTest2("1");
        System.out.println("user1："+user1.getUserName());
        return null;
    }

    @RequestMapping(value = "/getOos", method = GET)
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        R r = oosServices.test1();
        System.out.println(r);
        return null;
    }
}

