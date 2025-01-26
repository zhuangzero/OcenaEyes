package com.example.gpt.Controller;

import cn.hutool.core.lang.UUID;
import com.example.gpt.common.Result;
import com.example.gpt.service.ALiYunFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 23770
 * @createTime 2024/6/23 20:38
 * @description
 */


@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private ALiYunFileService fileService;

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        // 获取文件的输入流
        InputStream inputStream = file.getInputStream();
        // 生成文件名
        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
        // 调用文件上传方法
        String fileUrl = fileService.uploadFile(filename, inputStream);
//        返回？前面的内容
        return Result.success(fileUrl.split("\\?")[0]);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable("filename") String filename) throws IOException {

        // 调用文件下载方法
        InputStream inputStream = fileService.downloadFile(filename);
        // 设置文件响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(inputStream));
    }
}
