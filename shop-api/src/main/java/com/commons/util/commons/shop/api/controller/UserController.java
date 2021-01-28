package com.commons.util.commons.shop.api.controller;


import com.commons.util.commons.base.annotation.Token;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.base.util.IpUtils;
import com.commons.util.commons.shop.api.entity.User;
import com.commons.util.commons.shop.api.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("getUserList")
    public R getUserList(HttpServletRequest request) {
        String realIpAddress = IpUtils.getRealIpAddress(request);
        List<User> users= userService.list();
        log.error(realIpAddress);
      return R.success(users);
    }
}

