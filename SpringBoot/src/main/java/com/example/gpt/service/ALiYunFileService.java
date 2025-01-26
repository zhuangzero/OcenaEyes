package com.example.gpt.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;

/**
 * @author 23770
 * @createTime 2024/6/23 20:37
 * @description
 */


@Service
public class ALiYunFileService {


    @Autowired
    private OSSClient ossClient;

    @Value("${oss.bucketName}")
    private String bucketName;

    public String uploadFile(String filename, InputStream inputStream) {

        ossClient.putObject(bucketName, filename, inputStream);
        // 返回文件的URL
        return ossClient.generatePresignedUrl(bucketName, filename, new Date(System.currentTimeMillis() + 3600 * 1000)).toString().replace("http://", "https://");
    }

    public InputStream downloadFile(String filename) {

        OSSObject ossObject = ossClient.getObject(bucketName, filename);
        return ossObject.getObjectContent();
    }
}