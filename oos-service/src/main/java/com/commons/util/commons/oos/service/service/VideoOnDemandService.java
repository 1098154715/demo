package com.commons.util.commons.oos.service.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 视频点播服务
 * @author cxk
 * @date 2021/1/28 11:51
 */
public interface VideoOnDemandService {
    /**
     * 视频上传功能
     * @param file 视频上传
     * @return 访问地址url
     * */
    boolean videoUpload(MultipartFile file) throws IOException;

    /**
     * 音视频播放
     * @param videoId 视频上传
     * @return 访问地址url
     * */
    String GetVideoPlay(String videoId);
}
