package com.example.gpt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 23770
 * @createTime 2024/6/22 21:21
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String role;
    private String content;

}