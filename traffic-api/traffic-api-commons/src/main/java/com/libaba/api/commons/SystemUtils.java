package com.libaba.api.commons;

/*
  工具类
 */
public class SystemUtils {

    //用来补判断是否为空
    public static boolean isNull(Object object){
        return null==object;
    }

    /**
     * 判断字符串是否是空字符串
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str){
        return null==str||str.trim().equals("");
    }
}
