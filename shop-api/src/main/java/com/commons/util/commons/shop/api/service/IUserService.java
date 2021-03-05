package com.commons.util.commons.shop.api.service;

import com.commons.util.commons.shop.api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cxk
 * @since 2021-03-05
 */
public interface IUserService extends IService<User> {

    User getTest2(String s);
}
