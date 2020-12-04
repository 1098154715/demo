package com.itguigu.demo.controller;

import com.itguigu.demo.entity.Rules;
import com.itguigu.demo.mapper.RulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cxk
 * @date 2020/12/3 21:53
 */
@RestController
public class RulesController {
    @Autowired
    RulesMapper mapper;
   @GetMapping("/index")
    public Object test1(){
       List<Rules> rules = mapper.selectByMap(null);
       return rules;
    }
}
