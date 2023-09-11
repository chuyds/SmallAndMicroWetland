package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.aliyun.OSSUtils;
import com.ruoyi.system.service.OSSService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OSSServiceImpl implements OSSService {
    @Override
    public String uploadFile(MultipartFile file,String dir) {
        if (file.isEmpty()){
            return "文件不能为空";
        }
        return OSSUtils.uploadFile(file,dir);
    }
}
