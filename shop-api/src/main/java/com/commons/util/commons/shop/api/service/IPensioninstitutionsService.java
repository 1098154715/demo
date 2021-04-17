package com.commons.util.commons.shop.api.service;

import com.commons.util.commons.shop.api.entity.Pensioninstitutions;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxk
 * @since 2021-03-16
 */
public interface IPensioninstitutionsService extends IService<Pensioninstitutions> {

    List<Pensioninstitutions> listNew();

    List<Pensioninstitutions> getPensionAreaIsNull();

    List<Pensioninstitutions> selectBedNum();

    List<Pensioninstitutions> getAdderaAndContentsAreaisNull();
}
