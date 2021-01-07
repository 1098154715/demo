package com.commons.util.commons.shop.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.commons.util.commons.shop.api.entity.User;
import com.commons.util.commons.shop.api.mapper.UserMapper;
import com.commons.util.commons.shop.api.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cxk
 * @since 2021-01-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
