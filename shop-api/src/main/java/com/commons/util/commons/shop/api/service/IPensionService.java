package com.commons.util.commons.shop.api.service;

import com.commons.util.commons.shop.api.entity.Pension;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxk
 * @since 2021-04-16
 */
public interface IPensionService extends IService<Pension> {

    List<Pension> list1();

    void saveOrUpdate1(Pension ps);
}
