package com.commons.util.commons.oos.service.controller;

import com.commons.util.commons.base.controller.BaseController;
import com.commons.util.commons.base.entity.R;
import com.commons.util.commons.oos.service.service.VideoOnDemandService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**\
 视频上传控制器
 * @author cxk
 * @date 2021/1/28 14:00
 */
@ApiModel("视频上传控制器")
@RestController
@RequestMapping("uploadVideo")
public class UploadVideoController extends BaseController {


    @Autowired
    VideoOnDemandService videoOnDemandService;

    /**
     * 视频上传
     * @param file
     * @return
     */
    @PostMapping("/fileUpload")
    public R fileUpload(MultipartFile file) throws IOException {
      boolean flag=videoOnDemandService.videoUpload(file);
        return R.success(flag);
    }

    /**
     * 音视频播放
     * @param videoId 视频id
     * @return
     */
    @PostMapping("/GetVideoPlay")
    public R GetVideoPlay(String videoId){
        String url=videoOnDemandService.GetVideoPlay(videoId);
        return R.success(url);
    }
}
