package com.example.gpt.entity;

/**
 * @author 23770
 * @createTime 2024/6/22 22:07
 * @description
 */


import lombok.Data;

import java.util.List;

/**
 * TODO 图形模型返回响应体
 *
 * @author ss_419
 * @version 1.0
 * @date 2023/8/5 15:47
 */
@Data
public class GPTImageResponse {
    private String created;
    private List<GPTData> data;
}

