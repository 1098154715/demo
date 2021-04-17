package com.commons.util.commons.shop.api.mapper;

import com.commons.util.commons.shop.api.entity.Pension;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxk
 * @since 2021-04-16
 */
public interface PensionMapper extends BaseMapper<Pension> {

    List<Pension> list1();
}
