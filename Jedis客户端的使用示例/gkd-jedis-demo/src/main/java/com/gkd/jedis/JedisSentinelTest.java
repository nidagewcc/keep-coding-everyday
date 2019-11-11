package com.gkd.jedis;


import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class JedisSentinelTest {


    public static void main(String[] args) {
        String masterName = "redis-master";
        Set<String> sentinels = new HashSet<>();

        sentinels.add("192.168.52.200:26379");
        sentinels.add("192.168.52.201:26379");
        sentinels.add("192.168.52.202:26379");

        JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinels);

        pool.getResource().set("kaixin", "happy");
        System.out.println(pool.getResource().get("kaixin"));

        // 测试成功，Happy

    }
}
