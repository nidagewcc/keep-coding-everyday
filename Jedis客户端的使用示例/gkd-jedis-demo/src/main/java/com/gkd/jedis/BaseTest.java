package com.gkd.jedis;

import redis.clients.jedis.Jedis;

public class BaseTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.52.128", 6379);
        jedis.set("test", "1");
        System.out.println(jedis.get("test"));
        jedis.close();
    }
}
