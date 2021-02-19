package com.commons.util.commons.shop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cxk
 * @date 2020/12/31 15:13
 */
@SpringBootApplication
@EnableFeignClients(basePackages ="com.commons.util.commons.shop.api.feign")
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class);
    }
}
