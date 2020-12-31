package com.demo.utils;

import org.apache.commons.lang.RandomStringUtils;

public class SecurityUtils {
    public static String generatePasswordSalts(String password){
        //获取时间戳字符串
        String timestampStr = String.valueOf(System.currentTimeMillis());
        //获取随机数字符串
        String randomNumStr = RandomStringUtils.randomNumeric(timestampStr.length());
        //MD5加密明文密码
        String passwordMd5 = EncryptUtil.md5(password);
        //组合随机数,字符串,MD5密码
        String salt = randomNumStr+"-"+timestampStr+"-"+passwordMd5;
        //再次加密
        String saltMd5 = EncryptUtil.md5(salt);
        //组合返回最终密码
        return randomNumStr+"-"+timestampStr+"-"+saltMd5;
    }

    public static Boolean verifyPassword(String password,String encryptedPassword) {
        //获取前缀规则
        int indexOf = encryptedPassword.lastIndexOf("-");
        String prefix = encryptedPassword.substring(0, indexOf+1);
        //加密明文密码
        String saltMd5ThisPassword = prefix + EncryptUtil.md5((prefix + EncryptUtil.md5(password)));
        //验证比对密码
        if(saltMd5ThisPassword.equals(encryptedPassword)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(generatePasswordSalts("123456"));
    }
}
