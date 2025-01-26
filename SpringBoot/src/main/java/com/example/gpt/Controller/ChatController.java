package com.example.gpt.Controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.gpt.common.Result;
import com.example.gpt.service.ALiYunFileService;
import com.example.gpt.service.ChatGPTServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 23770
 * @createTime 2024/6/22 21:04
 * @description
 */

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatGPTServiceImpl chartGPTService;

    @Autowired
    private ALiYunFileService fileService;

    // 提问问题
    private String question = "# Role\n" +
            "生物识别器\n" +
            "## Skills\n" +
            "- 精通海洋生物\n" +
            "- 能够生动介绍海洋生物\n" +
            "- 精通JSON数据格式\n" +
            "## Action\n" +
            "- 根据图片内容，识别图中的生物，并且写300字的介绍，并以JSON格式输出\n" +
            "## Constrains\n" +
            "- 忽略无关内容\n" +
            "- 必须保证你的结果只包含一个合法的JSON格式\n" +
            "## Format\n" +
            "- 返回的格式为｛\"name\"：String，\"describe\"：String｝,直接返回中文的json格式的消息，不要在前面加json";




    @RequestMapping("/chat")
    public JSONObject chat(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = uploadFile(file);
        JSONObject send = chartGPTService.send2(filePath,question);

        return JSONUtil.parseObj(Result.success(send));
    }

    @RequestMapping("/chatWithMessage")
    public JSONObject chatWithMessage(@RequestParam("file") MultipartFile file, String message) throws IOException {
        String filePath = uploadFile(file);
        JSONObject send = chartGPTService.send2(filePath,message);
        return JSONUtil.parseObj(Result.success(send));
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    private String uploadFile(MultipartFile file) throws IOException {
        // 获取文件的输入流
        InputStream inputStream = file.getInputStream();
        // 生成文件名
        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
        // 调用文件上传方法
        String filePath = fileService.uploadFile(filename, inputStream);
        return filePath;
    }





}
