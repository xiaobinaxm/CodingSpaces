package com.robin;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/22 11:58
 */
public class MD5Utils {

    public static String encryption(String username,String password) {
        //加密算法
        String algorithmName = "MD5";
        //盐值
        Object salt = ByteSource.Util.bytes(username);
        //加密次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt, hashIterations);
        return simpleHash.toString();
    }
}

