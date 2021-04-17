package com.commons.util.commons.shop.api.service.impl;

import com.commons.util.commons.shop.api.entity.Pensioninstitutions;
import com.commons.util.commons.shop.api.mapper.PensioninstitutionsMapper;
import com.commons.util.commons.shop.api.service.IPensioninstitutionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxk
 * @since 2021-03-16
 */
@Service
public class PensioninstitutionsServiceImpl extends ServiceImpl<PensioninstitutionsMapper, Pensioninstitutions> implements IPensioninstitutionsService {


    @Override
    public List<Pensioninstitutions> listNew() {
        return baseMapper.listNew();
    }

    @Override
    public List<Pensioninstitutions> getPensionAreaIsNull() {
        return baseMapper.getPensionAreaIsNull();
    }

    @Override
    public List<Pensioninstitutions> selectBedNum() {
        return baseMapper.selectBedNum();
    }

    @Override
    public List<Pensioninstitutions> getAdderaAndContentsAreaisNull() {
        return baseMapper.getAdderaAndContentsAreaisNull();
    }
}
