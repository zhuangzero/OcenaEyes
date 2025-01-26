package com.example.gpt.common;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务器响应的数据最终都会返回该对象
 * @param <T>
 */
@Data
public class Result<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    public static <T> Result<T> success(T object) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> Result<T> error(String msg) {
        Result r = new Result();
        r.msg = msg;
        r.code = 0;
        return r;
    }

}