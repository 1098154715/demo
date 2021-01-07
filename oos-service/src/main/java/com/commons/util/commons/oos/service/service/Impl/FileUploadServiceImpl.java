package com.commons.util.commons.oos.service.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.commons.util.commons.oos.service.config.PropUtils;
import com.commons.util.commons.oos.service.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author cxk
 * @date 2020/12/31 16:05
 */
@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String fileUpload(MultipartFile file) {
        String url = null;
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String dataString = new DateTime().toString("yyyy/MM/dd");
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = PropUtils.ACCESSKEY_ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = PropUtils.ACCESSKEY_ID;
        String accessKeySecret = PropUtils.ACCESSKEY_SECRET;

        // 创建OSSClient实例。http://cxk-2020.oss-cn-beijing.aliyuncs.com/2021/01/04/b1996427dbd64e059f26d2944990352e/mylove.jpg
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。https://cxk-2020.oss-cn-beijing.aliyuncs.com/mylove.jpg
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        try {
        String    burl = dataString + "/" + uuid + "/" + fileName;
            ossClient.putObject(PropUtils.ACCESSKEY_BUCKETNAME,burl,file.getInputStream());
            url="http://"+PropUtils.ACCESSKEY_BUCKETNAME+"."+ PropUtils.ACCESSKEY_ENDPOINT+"/"+burl;

        } catch (Exception e) {
            log.error("文件上传失败");

        }
           // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

        ossClient.shutdown();
        return url;
    }
}
