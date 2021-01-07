package com.commons.util.commons.shop.api.mapper;

import com.commons.util.commons.shop.api.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cxk
 * @since 2021-01-07
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

}
