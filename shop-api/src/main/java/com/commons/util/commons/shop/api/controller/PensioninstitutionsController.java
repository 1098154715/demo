package com.commons.util.commons.shop.api.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.shop.api.entity.ManagementType;
import com.commons.util.commons.shop.api.entity.OrganizationType;
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
import java.util.HashMap;
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
       @Autowired
       IAdministrativeDivisionService administrativeDivisionService;
       @Autowired
       IManagementTypeService managementTypeService;
       @Autowired
       IOrganizationTypeService organizationTypeService;
    @Autowired
    ITest1pensioninstitutionsService test1pensioninstitutionsService;


    @GetMapping("getUserList")
    public R getUserList(HttpServletRequest request) {
        List<Pensioninstitutions> list = pensioninstitutionsService.list();
        List<Test1pensioninstitutions> test1= test1pensioninstitutionsService.list();
        List<Pensioninstitutions> pensioninstitutions = setManagementAndOrgnization(list);
        return R.success();
    }

    /**
     * 将机构类型和机构性质改为数据库对应的id
     * @param list
     * @return
     */
    public List<Pensioninstitutions> setManagementAndOrgnization(List<Pensioninstitutions> list){
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
        List<Integer> list1=new ArrayList<>();
       for(Pensioninstitutions ps:list){
           countNum++;
           try {

                   String address=ps.getContactAddress();
                    ps=getManagementTypeByps(ps);

               //设置点位
              /* ps = getBedNumByBedNum(ps);
               ps = getPhoneByPhone(ps);*/
             /* if(mapMangmentType.containsKey(ps.getManagementType())){
                   ps.setManagementType(mapMangmentType.get(ps.getManagementType())+"");
               }
               if(mapOrganizationType.containsKey(ps.getOrganizationType())){
                   ps.setOrganizationType(mapOrganizationType.get(ps.getOrganizationType())+"");
               }*/
               pensioninstitutionsService.saveOrUpdate(ps);
           }catch (Exception e){
               countErr++;
               list1.add(ps.getId());
           }
           System.out.println("当前执行条数："+countNum+"::::"+   ps.getId());

       }
        System.out.println("成功条数："+countNum);
        System.out.println("失败条数："+countErr);
        System.out.println("错误集合"+list1);

     return list;
    }

    private Pensioninstitutions getManagementTypeByps(Pensioninstitutions ps) {
        switch (ps.getManagementType()){
            case "1":
            case "7":
                //公办公营
               ps.setManagementType("2");
               break;
            case "3":
                //公办民营
                ps.setManagementType("1");
                break;
            case "4":
            case "5":
                //民办民营
                ps.setManagementType("3");
                break;
            default:{
            ps.setManagementType("4");
            }
        }


        return ps;
    }

    /**
     * 根据详细地址获取点位
     */
    public Pensioninstitutions getPointByContentsAddress(Pensioninstitutions pensioninstitutions,String address){

       Geocodes result = GaoDeAddressUtil.getResult(address);
        if(result!=null){
            pensioninstitutions.setAddrarea(result.getProvince()+","+result.getCity()+","+result.getDistrict());
            pensioninstitutions.setContactAddress(result.getFormatted_address());
            pensioninstitutions.setAddrPoint(result.getLocation());
            String[] locat=result.getLocation().split(",");
            if(locat!=null&&locat.length==2){
                pensioninstitutions.setGdlng(locat[0]);
                pensioninstitutions.setGdlat(locat[1]);
            }
            if(!StringUtils.isEmpty(pensioninstitutions.getContacts())){
                String contacts=pensioninstitutions.getContacts().replace("联系人：","");
                pensioninstitutions.setContacts(contacts);
            }




        }

        return pensioninstitutions;
    }

    public Pensioninstitutions getPhoneByPhone(Pensioninstitutions pensioninstitutions){
        if(pensioninstitutions.getPhone()==null){
            return pensioninstitutions;
        }
        if(pensioninstitutions.getPhone().contains("联系方式：")){
            String phone=pensioninstitutions.getPhone().replace("联系方式：","");
           pensioninstitutions.setPhone(phone);
        }
        if(pensioninstitutions.getPhone().contains("/")){
            String[] phones = pensioninstitutions.getPhone().split("/");
            if(phones.length>=2){
                pensioninstitutions.setPhone(phones[0]);
                pensioninstitutions.setPhone2(phones[1]);
            }
        }
        return pensioninstitutions;
    }
    public Pensioninstitutions getBedNumByBedNum(Pensioninstitutions pensioninstitutions){
        if(pensioninstitutions.getBedNum()==null){
            return pensioninstitutions;
        }
        String[] bedNums=pensioninstitutions.getBedNum().split("-");
        String bed=pensioninstitutions.getBedNum();
        bed=bed.replace("床位数：","");
        bed=bed.replace("张以内：","");
        bed=bed.replace("张以上：","");
        bed=bed.replace("暂无信息：","");
        bed=bed.replace("张","");
        if(bedNums.length>=2){
            bed=bedNums[1];
        }
        pensioninstitutions.setBedNum(bed);
        return pensioninstitutions;
    }
}

