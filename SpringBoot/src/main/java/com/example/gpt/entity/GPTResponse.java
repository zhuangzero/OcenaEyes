package com.example.gpt.entity;

/**
 * @author 23770
 * @createTime 2024/6/22 22:07
 * @description
 */

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TODO 文本模型返回响应体
 *
 * @author ss_419
 * @version 1.0
 * @date 2023/8/5 15:47
 */
@Data
public class GPTResponse {
    private String id;
    private String object;
    private String created;
    private String model;
    private List<GPTChoice> choices;

}
