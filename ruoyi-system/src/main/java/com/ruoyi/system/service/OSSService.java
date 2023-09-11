package com.ruoyi.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface OSSService {
    public String uploadFile(MultipartFile file,String dir);
}
