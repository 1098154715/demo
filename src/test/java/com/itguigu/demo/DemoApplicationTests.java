package com.itguigu.demo;


import com.itguigu.demo.entity.Rules;
import com.itguigu.demo.mapper.OrderMapper;
import com.itguigu.demo.mapper.RulesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    RulesMapper rulesMapper;

    @Test
    public void contextLoads() {
        System.out.println(rulesMapper);
        rulesMapper.deleteById("100");

    }

}
