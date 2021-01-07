package com.commons.util.commons.shop.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cxk
 * @date 2020/12/31 16:12
 */

@Configuration
@MapperScan("com.commons.util.commons.shop.api.mapper")
@EnableSwagger2
public class SwaggerConfig {
}