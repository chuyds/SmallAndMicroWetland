package com.ruoyi.web.controller.common;


import com.ruoyi.system.service.OSSService;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common-upload")
public class UploadController {
    @Autowired
    private OSSService ossService;

//    @RequestParam("file") MultipartFile file,
//    value = "/fileUpload", consumes = "multipart/form-data"
    @PostMapping("/file")
    public String uploadFiles(HttpServletRequest request){
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return "上传的数据类型不正确";
        }
//        String filePath = ossService.uploadFile(file, "img");
//        System.out.println(filePath);
        return "上传成功";
    }

    @PostMapping("/fileUpload")
    public String uploadFiles(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return "上传的数据类型不正确";
        }
        String filePath = ossService.uploadFile(file, "img");
        System.out.println(filePath);
        return "上传成功";
    }

}
