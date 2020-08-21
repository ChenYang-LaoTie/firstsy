package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * @Description: MD5Utils
 * @Author ChenYang
 * @Date 2020/8/20   3:04 下午
 */
public class MD5Util {
    private static final String SALT = "&%5123***&&%%$$#@";

    public static String getMD5(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        String base = str + "/" + SALT;

        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.getMD5("111111"));
    }
}
