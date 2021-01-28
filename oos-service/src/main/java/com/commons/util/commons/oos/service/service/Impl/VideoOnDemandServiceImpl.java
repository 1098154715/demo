package com.commons.util.commons.oos.service.service.Impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.commons.util.commons.oos.service.config.PropUtils;
import com.commons.util.commons.oos.service.service.VideoOnDemandService;
import com.commons.util.commons.oos.service.util.UploadVideoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 视频点播服务
 * @author cxk
 * @date 2021/1/28 11:51
 */
@Service
public class VideoOnDemandServiceImpl implements VideoOnDemandService {

    @Override
    public boolean videoUpload(MultipartFile file) throws IOException {
       return UploadVideoUtil.uploadVideo(file.getName(),file.getOriginalFilename(),file.getInputStream());
    }

    /**
     * 音视频播放
     * @param videoId 视频id
     * @return
     */
    @Override
    public String GetVideoPlay(String videoId) {
     String url="";
            GetPlayInfoRequest request = new GetPlayInfoRequest();
            request.setVideoId("ec07a9370923413ba805de235d46c27b");
        DefaultAcsClient defaultAcsClient = UploadVideoUtil.getDefaultAcsClient();
        try {
            GetPlayInfoResponse response = defaultAcsClient.getAcsResponse(request);
            try {

                List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
                //播放地址
                for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                    url= playInfo.getPlayURL() ;
                }
                //Base信息
                System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
            } catch (Exception e) {
                System.out.print("ErrorMessage = " + e.getLocalizedMessage());
            }
            System.out.print("RequestId = " + response.getRequestId() + "\n");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return url;
    }


}
