package com.example.gpt.entity;

/**
 * @author 23770
 * @createTime 2024/6/22 22:07
 * @description
 */


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * TODO 文本模型消息体
 *
 * @author ss_419
 * @version 1.0
 * @date 2023/8/5 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String role;
    private Object content;
}

