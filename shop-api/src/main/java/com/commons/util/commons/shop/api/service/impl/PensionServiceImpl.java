package com.commons.util.commons.shop.api.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.commons.util.commons.shop.api.entity.Pension;
import com.commons.util.commons.shop.api.mapper.PensionMapper;
import com.commons.util.commons.shop.api.service.IPensionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxk
 * @since 2021-04-16
 */
@Service
public class PensionServiceImpl extends ServiceImpl<PensionMapper, Pension> implements IPensionService {


    @DS("db03")
    @Transactional
    @Override
    public List<Pension> list1() {
        return baseMapper.list1();
    }
    @DS("db03")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdate1(Pension ps) {
        baseMapper.updateById(ps);
    }
}
