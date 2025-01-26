package com.example.gpt.entity;

/**
 * @author 23770
 * @createTime 2024/6/22 22:05
 * @description
 */



import lombok.Data;
/**
 * TODO 文本模型返回内容
 *
 * @author ss_419
 * @version 1.0
 * @date 2023/8/5 15:47
 */
@Data
public class GPTChoice {
    private String text;
    private Integer index;
    private Message message;

}

