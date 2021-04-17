package com.commons.util.commons.shop.api.mapper;

import com.commons.util.commons.shop.api.entity.Pensioninstitutions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxk
 * @since 2021-03-16
 */
public interface PensioninstitutionsMapper extends BaseMapper<Pensioninstitutions> {

    List<Pensioninstitutions> listNew();

    List<Pensioninstitutions> getPensionAreaIsNull();

    List<Pensioninstitutions> selectBedNum();

    List<Pensioninstitutions> getAdderaAndContentsAreaisNull();
}
