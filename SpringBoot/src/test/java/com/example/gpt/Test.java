package com.example.gpt;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.gpt.common.Result;
import com.example.gpt.entity.GPTRequest;
import com.example.gpt.entity.Message2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 23770
 * @createTime 2024/6/24 23:17
 * @description
 */


public class Test {
    @org.junit.jupiter.api.Test
    void contextLoads() {
        String a = "{\n" +
                "    \"code\": 1,\n" +
                "    \"msg\": null,\n" +
                "    \"data\": \"```json{  \\\"name\\\": \\\"Mangrove Forest\\\",  \\\"describe\\\": \\\"This image shows a dense mangrove forest located next to a body of water. A long wooden walkway extends over the mangroves and leads to a small pavilion above the water, offering a scenic view. The vibrant green of the mangroves contrasts beautifully with the blue of the water, creating a picturesque landscape.\\\"}```\"\n" +
                "}";
        String n = a.replaceAll("\\\\\\\"","\\\"");
        System.out.println(a);
        System.out.println(n);

        String d = "1234?567";
        System.out.println(d.split("\\?")[0]);
    }
    @org.junit.jupiter.api.Test
    void  test2(){
        String model = "111";
        Integer maxTokens = 1;
        Double temperature = 1.0;
        GPTRequest request = new GPTRequest();
        request.setModel(model);
        request.setMax_tokens(maxTokens);
        request.setTemperature(temperature);
        Message2 messages = new Message2();
        messages.setRole("system");
        List<Map> list = new ArrayList<>();
                Map textMap = new LinkedHashMap();
        textMap.put("type","text");
        textMap.put("text","prompt");
        Map imageMap = new LinkedHashMap();
        imageMap.put("type","image_url");
        imageMap.put("image_url","filePath");
        list.add(textMap);
        list.add(imageMap);
        messages.setContent(list);
        List list1 = new ArrayList();
        list1.add(messages);
        request.setMessages(list1);
        System.out.println(JSONUtil.toJsonStr(request));
    }
    @org.junit.jupiter.api.Test
    void Test3(){
        String a ="{\n" +
                "  \"name\": \"金鱼\",\n" +
                "  \"describe\": \"这是一条金鱼，具体品种可能是血鹦鹉。它的身体呈鲜艳的橙红色，鱼鳞闪闪发亮，背鳍高耸，眼睛大而圆。血鹦鹉是一种热带淡水鱼，因其艳丽的颜色和温和的性格深受鱼友喜爱，常见于家庭水族箱中。\"\n" +
                "}";
        JSONObject entries = JSONUtil.parseObj(a);
        Result<JSONObject> success = Result.success(entries);
        System.out.println(success);
    }
}
