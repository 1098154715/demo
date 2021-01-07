package com.commons.util.commons.oos.service.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author cxk
 * @date 2020/12/31 16:04
 */
public interface FileUploadService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String fileUpload(MultipartFile file);
}
