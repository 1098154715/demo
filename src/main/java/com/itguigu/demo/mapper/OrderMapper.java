package com.itguigu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itguigu.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author cxk
 * @date 2020/12/3 20:32
 */
@Component
public interface OrderMapper extends BaseMapper<Order> {
}
