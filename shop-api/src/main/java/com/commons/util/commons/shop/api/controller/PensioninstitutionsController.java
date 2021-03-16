package com.commons.util.commons.shop.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.shop.api.entity.Pensioninstitutions;
import com.commons.util.commons.shop.api.service.IPensioninstitutionsService;
import com.commons.util.commons.shop.api.util.gaode.GaoDeAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxk
 * @since 2021-03-16
 */
@RestController
@RequestMapping("/pensioninstitutions")
public class PensioninstitutionsController {

       @Autowired
       IPensioninstitutionsService pensioninstitutionsService;

    @GetMapping("getUserList")
    public R getUserList(HttpServletRequest request) {
        List<Integer> list1=new ArrayList<>();
        QueryWrapper<Pensioninstitutions> wrapper=new QueryWrapper<>();
        wrapper.isNull("GDlng");
        List<Pensioninstitutions> list = pensioninstitutionsService.list(wrapper);
        System.out.println("总条数："+list.size());
        for(Pensioninstitutions pensioninstitutions:list){
            String area=pensioninstitutions.getChargeArea();
            System.out.println("area改之前:"+area);
            Map<String, Object> result = GaoDeAddressUtil.getResult(pensioninstitutions.getContactAddress());
            String addpoint=(String) result.get("location");
            System.out.println("result:"+addpoint);
            pensioninstitutions.setAddrPoint(addpoint);
            if(addpoint.contains(",")){
                String[] arr=addpoint.split(",");
                pensioninstitutions.setGdlng(arr[0]);
                pensioninstitutions.setGdlat(arr[1]);
            }
            try {
                Integer num=Integer.valueOf(area);
            }catch (Exception e){
                String[] split = area.split("-");
                Integer num1=0;
                try {
                    num1=Integer.valueOf(split[1]);
                }catch (Exception e1){
                    list1.add(pensioninstitutions.getId());
                }
                if(num1<=3000){
                    pensioninstitutions.setChargeArea("28");
                }else if(num1<=8000){
                    pensioninstitutions.setChargeArea("31");
                }else if(num1>8000){
                    pensioninstitutions.setChargeArea("103");
                }
            }
            System.out.println("area改之后:"+pensioninstitutions.getChargeArea());
            System.out.println("错误条数："+list1.size());
            System.out.println(list1);
            //pensioninstitutionsService.save(pensioninstitutions);

        }


        return R.success(null);
    }
}

