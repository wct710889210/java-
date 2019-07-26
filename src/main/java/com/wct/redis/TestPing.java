package com.wct.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class TestPing {
    public static void main(String[] args) {
        JedisShardInfo shardInfo = new JedisShardInfo("redis://212.64.11.56:6379");
        shardInfo.setPassword("wct123456");
        Jedis jedis = new Jedis(shardInfo);
        System.out.println(jedis.ping());
//        jedis.set("k1","v1");
//        jedis.set("k2","v2");
//        jedis.set("k3","v3");
    }
}
