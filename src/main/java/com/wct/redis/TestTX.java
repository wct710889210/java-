package com.wct.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        Transaction transaction = jedis.multi();
        transaction.exec();
    }
}
