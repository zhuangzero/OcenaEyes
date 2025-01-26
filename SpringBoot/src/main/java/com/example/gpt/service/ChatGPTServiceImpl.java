package com.example.gpt.service;

/**
 * @author 23770
 * @createTime 2024/6/22 22:08
 * @description
 */




import cn.hutool.http.Header;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.gpt.entity.GPTRequest;
import com.example.gpt.entity.GPTResponse;
import com.example.gpt.entity.Message;
import com.example.gpt.entity.Message2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service("chartGPTService")
public class ChatGPTServiceImpl  {
    @Value("${ChatGPT.variables.apiKey}")
    private String apiKey;
    @Value("${ChatGPT.variables.maxTokens}")
    private String maxTokens;
    @Value("${ChatGPT.variables.model}")
    private String model;
    @Value("${ChatGPT.variables.temperature}")
    private String temperature;

//    @Override
//    public JSONObject send(String filePath, String prompt) {
//
//        JSONObject bodyJson = new JSONObject();
//        Message message = new Message();
//        List<Map<String,String>> maps = new ArrayList<>();
//        Map textMap = new LinkedHashMap();
//        textMap.put("type","text");
//        textMap.put("text",prompt);
//        maps.add(textMap);
//        Map imageMap = new LinkedHashMap();
//        imageMap.put("type","image_url");
//        imageMap.put("image_url",filePath);
//        maps.add(imageMap);
//        message.setContent(maps);
//        message.setRole("system");
//        ArrayList<Message> messages = new ArrayList<>();
//        messages.add(message);
//        bodyJson.put("messages", messages);
//        bodyJson.put("model", model);
//        bodyJson.put("max_tokens", Integer.parseInt(maxTokens));
//        bodyJson.put("temperature", Double.parseDouble(temperature));
//        Map<String, Object> headMap = new HashMap<>();
//        System.out.println("5     "+JSONUtil.toJsonStr(bodyJson));
//        HttpResponse httpResponse =
//                // 官网请求，没梯子不能访问
//                // HttpUtil.createPost("https://api.openai.com/v1/chat/completions")
//                // 使用代理地址 https://api.openai-proxy.com/
//                HttpUtil.createPost("https://api.lqqq.ltd/v1/chat/completions")
//                        .header(Header.AUTHORIZATION, "Bearer " + apiKey)
//                        .header(Header.CONTENT_TYPE, "application/json")
//                        .body(JSONUtil.toJsonStr(bodyJson)).execute();
//        String resStr = httpResponse.body();
//        System.out.println("1:    "+resStr);
//
//        GPTResponse gptResponse = JSONUtil.toBean(resStr, GPTResponse.class);
//        System.out.println("2:    "+gptResponse);
//
//        return JSONUtil.parseObj(gptResponse.getChoices().get(0).getMessage().getContent());
////        return gptResponse.getChoices().get(0).getMessage().getContent().toString().replaceAll("\\n", "");
//    }

    public JSONObject send2(String filePath, String prompt) {


        GPTRequest request = new GPTRequest();
        request.setModel(model);
        request.setMax_tokens(Integer.parseInt(maxTokens));
        request.setTemperature(Double.valueOf(temperature));
        Message2 messages = new Message2();
        messages.setRole("system");

        request.setContentMap(messages,prompt,filePath);

        System.out.println("requset:   "+JSONUtil.toJsonStr(request));
        HttpResponse httpResponse =
                // 官网请求，没梯子不能访问
                // HttpUtil.createPost("https://api.openai.com/v1/chat/completions")
                // 使用代理地址 https://api.openai-proxy.com/
                HttpUtil.createPost("https://api.lqqq.ltd/v1/chat/completions")
                        .header(Header.AUTHORIZATION, "Bearer " + apiKey)
                        .header(Header.CONTENT_TYPE, "application/json")
                        .body(JSONUtil.toJsonStr(request)).execute();
        String resStr = httpResponse.body();

        GPTResponse gptResponse = JSONUtil.toBean(resStr, GPTResponse.class);
        System.out.println("gptResponse:    "+gptResponse);
        return JSONUtil.parseObj(gptResponse.getChoices().get(0).getMessage().getContent());
//        return gptResponse.getChoices().get(0).getMessage().getContent().toString().replaceAll("\\n", "");
    }



//    @Override
//    public List<GPTData> sendImg(String prompt) {
//        JSONObject bodyJson = new JSONObject();
//        bodyJson.put("prompt", prompt);
//        bodyJson.put("n", 2);
//        bodyJson.put("size", "1024x1024");
//        Map<String, Object> headMap = new HashMap<>();
//        headMap.put("Authorization", "Bearer " + apiKey);
//        HttpResponse httpResponse =
//                // 官网请求，没梯子不能访问
//                // HttpUtil.createPost("https://api.openai.com/v1/chat/completions")
//                // 使用代理地址 https://api.openai-proxy.com/
//                HttpUtil.createPost("https://api.openai-proxy.com/v1/images/generations")
//                        .header(Header.AUTHORIZATION, "Bearer " + apiKey)
//                        .header(Header.CONTENT_TYPE, "application/json")
//                        .body(JSONUtil.toJsonStr(bodyJson)).execute();
//        String resStr = httpResponse.body();
//
//        GPTImageResponse gptResponse = JSONUtil.toBean(resStr, GPTImageResponse.class);
//
//        List<GPTData> data = gptResponse.getData();
//
//        return data;
//
//    }


}
