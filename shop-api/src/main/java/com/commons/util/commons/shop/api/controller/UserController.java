package com.commons.util.commons.shop.api.controller;


import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.shop.api.entity.User;
import com.commons.util.commons.shop.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("getUserList")
    public R getUserList() {
      List<User> users= userService.list();
      return R.success(users);
    }
}

