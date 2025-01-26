package com.example.gpt.entity;

/**
 * @author 23770
 * @createTime 2024/6/22 22:07
 * @description
 */


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 问题请求体
 *
 * @author ss_419.
 *
 * @version 1.0
 * @date 2023/8/5 15:47
 */
@Data
public class GPTRequest {
    private String id;
    private List<Message2> messages;
    private String model;
    private Integer max_tokens;
    private Double temperature;

    public void setContentMap(Message2 messages, String prompt, String filePath) {
        List<Map> list = new ArrayList<>();
        Map textMap = new LinkedHashMap();
        textMap.put("type","text");
        textMap.put("text",prompt);
        Map imageMap = new LinkedHashMap();
        imageMap.put("type","image_url");
        imageMap.put("image_url",filePath);
        list.add(textMap);
        list.add(imageMap);
        messages.setContent(list);

        List list1 = new ArrayList();
        list1.add(messages);
        this.setMessages(list1);
    }
}

