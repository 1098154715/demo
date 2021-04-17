package com.commons.util.commons.shop.api.controller;


import com.alibaba.druid.util.StringUtils;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.shop.api.entity.Pension;
import com.commons.util.commons.shop.api.entity.Pensioninstitutions;
import com.commons.util.commons.shop.api.entity.Test1pensioninstitutions;
import com.commons.util.commons.shop.api.entity.utilEntity.Geocodes;
import com.commons.util.commons.shop.api.service.*;
import com.commons.util.commons.shop.api.util.gaode.GaoDeAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxk
 * @since 2021-04-16
 */
@RestController
@RequestMapping("/pension")
public class PensionController {
    @Autowired
    IPensionService pensionService;



    @GetMapping("getUserList")
    public R getUserList(HttpServletRequest request) {
        List<Pension> list = pensionService.list1();
        setManagementAndOrgnization(list);
        return R.success();
    }

    /**
     * 将机构类型和机构性质改为数据库对应的id
     * @param list
     * @return
     */
    public List<Pension> setManagementAndOrgnization(List<Pension> list){
     /*  List<ManagementType> ManagementTypeList = managementTypeService.list();
        Map<String,Integer> mapMangmentType=new HashMap<>();
        for(ManagementType m:ManagementTypeList){
            mapMangmentType.put(m.getName(),m.getId());
        }
        Map<String,Integer> mapOrganizationType=new HashMap<>();
        List<OrganizationType> OrganizationType = organizationTypeService.list();
        for(OrganizationType m:OrganizationType){
            mapOrganizationType.put(m.getName(),m.getId());
        }*/

        Integer countNum=0;
        Integer countErr=0;
        List<String> list1=new ArrayList<>();
        for(Pension ps:list){
            countNum++;
            try {
                ps=getPensionLocation(ps);
                ps=getgetTypeeByPension(ps);
                //设置点位
              /* ps = getBedNumByBedNum(ps);
               ps = getPhoneByPhone(ps);*/
             /* if(mapMangmentType.containsKey(ps.getManagementType())){
                   ps.setManagementType(mapMangmentType.get(ps.getManagementType())+"");
               }
               if(mapOrganizationType.containsKey(ps.getOrganizationType())){
                   ps.setOrganizationType(mapOrganizationType.get(ps.getOrganizationType())+"");
               }*/
                pensionService.saveOrUpdate1(ps);
            }catch (Exception e){
                countErr++;
                list1.add(ps.getName());
            }
            System.out.println("当前执行条数："+countNum+"::::"+   ps.getName());

        }
        System.out.println("成功条数："+countNum);
        System.out.println("失败条数："+countErr);
        System.out.println("错误集合"+list1);

        return list;
    }

    private Pension getgetTypeeByPension(Pension ps) {
        if(ps.getType()==null){
            return  ps;
        }
        switch (ps.getType()){
            case "民非":
            case "民非  城镇":
            case "公建公营":
            case "公办公营":
            case "市级公办":
            case "政府公办":
            case "国办":
            case "7":
                //公办公营
                ps.setType("2");
                break;
            case "公办民营":
            case "无民非":
            case "公建民营":
            case "公办":
            case "公办私营":
            case "公办  农村":
            case "天山区公办民营":
            case "国有公建民营":
            case "新市区公建民营":
            case "米东区公建民营":
                //公办民营
                ps.setType("1");
                break;
            case "民办":
            case "民营":
            case "企业":
            case "自有":
            case "民办养老机构":
            case "民办民营":
            case "营利性":
            case "民建民营":
            case "民建公助":
            case "民办 ":
            case "天山区民办 ":
            case "沙区民办 ":
            case "新市区民办 ":
            case "水区民办 ":
            case "头区民办 ":
            case "米东区民办 ":
            case "乌鲁木齐县民办 ":
            case "社区办 ":
            case "村办":
            case " ":
            case "公建民营 ":
                //民办民营
                ps.setType("3");
                break;
            case "事业":
            case "工商":
            case "PPP模式":
            case "社会办":
            case "工商  城镇":
            case "停办":
            case "1097":
            case "宗教办":
                ps.setType("4");
                break;
            default:{
                ps.setType("4");
            }
        }


        return ps;
    }

    /**
     * 根据详细地址获取点位
     */
    public Pension getPensionLocation(Pension pension){

        Geocodes result = GaoDeAddressUtil.getResult(pension.getArea()+pension.getAddress());
        if(result==null){
            result = GaoDeAddressUtil.getResult(pension.getName());
        }
        if(result!=null){
            pension.setAddress(result.getProvince()+","+result.getCity()+","+result.getDistrict());
            pension.setArea(result.getFormatted_address());
            pension.setPoint(result.getLocation());
            String[] locat=result.getLocation().split(",");
            if(locat!=null&&locat.length==2){
                pension.setLog(locat[0]);
                pension.setLat(locat[1]);
            }
        }

        return pension;
    }
}

