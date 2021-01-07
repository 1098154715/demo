package com.commons.util.commons.oos.service.controller.account;

import com.commons.util.commons.base.annotation.Token;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.oos.service.config.PropUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxk
 * @date 2021/1/7 13:50
 */
@ApiModel("账户控制器")
@RestController
@RequestMapping("account")
public class AccountController {

    @GetMapping("/test")
    @Token(value = true)
    @ApiImplicitParams(@ApiImplicitParam(name = "token", value = "用户标识", required = true, paramType = "header", dataType = "String"))
    public R fileUpload(){
        String cp= PropUtils.ALI_APPKEY;
        System.out.println(cp);
        return R.success(cp);
    }
}
