package com.example.gpt.common;

import com.qiniu.storage.model.DefaultPutRet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResult {
    /**
     * 七牛云返回结果类
     */
    private DefaultPutRet putRet;
    /**
     * 图片外链地址
     */
    private String imgName;
}
