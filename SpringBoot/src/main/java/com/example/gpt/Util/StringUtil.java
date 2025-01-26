package com.example.gpt.Util;


import java.util.UUID;

public class StringUtil {

    /**
     * @Description: 生成唯一图片名称
     * @Param: fileName
     * @return: 云服务器fileName
     */
    public static String getRandomImgName(String fileName) {
        int index = fileName.lastIndexOf(".");
        if ((fileName == null || fileName.isEmpty()) || index == -1){
            throw new IllegalArgumentException();
        }
        // 获取文件后缀
        String suffix = fileName.substring(index);
        // 生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 生成上传至云服务器的路径
//        String path = "news/crush/"+ DateUtil.today() + "-" + uuid + suffix;
//        上传至image文件夹上
        String path = "image/" + uuid + suffix;
        return path;
    }
}
