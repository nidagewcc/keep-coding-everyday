package com.gkd.jedis.single;

import redis.clients.jedis.Jedis;

/**
 * 单机版连接测试
 */
public class SingleTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.52.128", 6379);
        jedis.set("test", "1");
        System.out.println(jedis.get("test"));
        jedis.close();
    }
}
