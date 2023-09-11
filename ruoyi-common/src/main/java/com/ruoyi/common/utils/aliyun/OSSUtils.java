package com.ruoyi.common.utils.aliyun;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.ruoyi.common.utils.uuid.UUID;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSUtils {
    public static void main(String[] args) {
        String path = localUploadFile(new File("E://a.txt"));
        System.out.println(path);
    }

    public static String uploadFile(MultipartFile multipartFile, String dir) {
        // Region请按实际情况填写。
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        // STS临时访问密钥AccessKey ID和AccessKey Secret。
        String accessKeyId = "";
        String accessKeySecret = "";
        // 使用代码嵌入的STS临时访问密钥和安全令牌配置访问凭证。
        CredentialsProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "small-and-micro-wetland";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

        try {
            InputStream inputStream = multipartFile.getInputStream();

            //获取日期作为目录
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = simpleDateFormat.format(new Date());

            //获取完整的文件存储路径（包含文件名）
            String originalFilename = multipartFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString();
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = dir + "/" +datePath + "/" + filename + substring;

            //上传
            ossClient.putObject(bucketName, objectName, inputStream);

            return "https://" + bucketName + "." + endpoint + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (Exception ce) {
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return "upload fail";
    }

    public static String uploadFile(MultipartFile multipartFile) {
        return uploadFile(multipartFile,"");
    }

    public static String localUploadFile(File file) {
        // Region请按实际情况填写。
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        // STS临时访问密钥AccessKey ID和AccessKey Secret。
        String accessKeyId = "";
        String accessKeySecret = "";
        // 使用代码嵌入的STS临时访问密钥和安全令牌配置访问凭证。
        CredentialsProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "small-and-micro-wetland";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

        try {
            InputStream inputStream = new FileInputStream(file);

            //获取日期作为目录
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = simpleDateFormat.format(new Date());

            //获取完整的文件存储路径（包含文件名）
            String originalFilename = file.getName();
            String filename = UUID.randomUUID().toString();
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = datePath + "/" + filename + substring;

            //上传
            ossClient.putObject(bucketName, objectName, inputStream);

            return "https://" + bucketName + "." + endpoint + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (Exception ce) {
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return "upload fail";
    }
}
