package com.gkd.jedis.util;

import redis.clients.jedis.Jedis;

/**
 * 工具类封装
 *
 * @date 2019/11/12
 * @description
 */
public class JedisUtils {


    public static void main(String[] args) {
        String str = "abc";
        System.out.println("str的length：" + str.length());
        System.out.println("str的bytes：" + str.getBytes().length);
    }


}
