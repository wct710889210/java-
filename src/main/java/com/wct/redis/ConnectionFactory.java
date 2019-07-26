package com.wct.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class ConnectionFactory {
    private static Jedis conn;

    public static Jedis getConn(){
        if(conn==null){
            JedisShardInfo shardInfo = new JedisShardInfo("redis://212.64.11.56:6379");
            shardInfo.setPassword("wct123456");
            conn = new Jedis(shardInfo);
        }
        return conn;
    }
}
