package com.commons.util.commons.oos.service.controller;

import com.alibaba.druid.util.StringUtils;
import com.commons.util.commons.base.annotation.Token;
import com.commons.util.commons.base.controller.BaseController;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.oos.service.config.PropUtils;
import com.commons.util.commons.oos.service.service.FileUploadService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cxk
 * @date 2020/12/31 15:27
 */
@ApiModel("文件上传控制器")
@RestController
@RequestMapping("fileUpload")
public class FileUploadController extends BaseController {

    @Autowired
    FileUploadService fileUploadService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/fileUpload")
    public R fileUpload(MultipartFile file){
               String url=fileUploadService.fileUpload(file);
        return R.success(url);
    }
    @GetMapping("/test")
    @Token(value = false)
    public R fileUpload(){
        String cp=PropUtils.ALI_APPKEY;
        System.out.println(cp);
        return R.success("我的nacos成功了");
    }
    @GetMapping("/getIPAddress")
    @Token
    public static R getIPAddress(HttpServletRequest request) {
        String sourceIp = null;
        System.out.println("我是oos接口");
        String ipAddresses = request.getHeader("x-forwarded-for");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getRemoteAddr();
        }
        if (!StringUtils.isEmpty(ipAddresses)) {
            sourceIp = ipAddresses.split(",")[0];
        }

        return R.success(sourceIp);
    }



}
