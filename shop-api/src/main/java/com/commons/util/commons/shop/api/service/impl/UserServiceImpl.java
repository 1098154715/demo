package com.commons.util.commons.shop.api.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.commons.util.commons.shop.api.entity.User;
import com.commons.util.commons.shop.api.mapper.UserMapper;
import com.commons.util.commons.shop.api.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cxk
 * @since 2021-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;


    @DS("db02")
    @Transactional
    @Override
    public User getTest2(String s) {
        return userMapper.selectById(s);
    }
}
