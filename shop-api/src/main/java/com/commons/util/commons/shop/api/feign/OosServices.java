package com.commons.util.commons.shop.api.feign;

import com.commons.util.commons.base.entity.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxk
 * @date 2021/2/18 17:14
 */
@FeignClient("oos-nacosservice")
@Component
public interface OosServices {
    @RequestMapping("fileUpload/test")
     R test1();

}
