package com.wct.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class MarketPractice {

    private Jedis conn = ConnectionFactory.getConn();

    public boolean listItem(Jedis conn,String itemId,int sellerId,Integer price){
        String inventory = "inventory:"+sellerId;
        String item = "itemId."+sellerId;
        long end = System.currentTimeMillis()+5000;

        while (System.currentTimeMillis()<end){
            conn.watch(inventory);

            if(!conn.sismember(inventory,itemId)){
                conn.unwatch();
                System.out.println("user:"+sellerId+"不存在货物「"+itemId+"」");
                return false;
            }
            Transaction tran = conn.multi();
            tran.srem(inventory,itemId);
            tran.zadd("market",price,item);
            List<Object> results = tran.exec();
            if(results != null){
                System.out.println("user:"+sellerId+"的货物「"+itemId+"」已经加入市场");
                break;
            }else{
                System.out.println("user:"+sellerId+"的货物「"+itemId+"」加入市场失败，用户背包发生变化");
            }
        }

        return false;
    }

    public void addItemToInventory(int userId,String item){
        String inventory = "inventory:"+userId;
        if(conn.sadd(inventory,item)>0){
            System.out.println("添加「"+item+"」到「"+inventory+"」成功");
        }else{
            System.out.println("添加「"+item+"」到「"+inventory+"」失败");
        }
    }

    public void createUser(String name){
        int id = Integer.parseInt(conn.get("nextId"));
        if(conn.hsetnx("user:"+id,"name",name)==1){
            conn.hset("user:"+id,"funds","100");
            conn.set("nextId", String.valueOf(id+1));
            System.out.println("创建用户「user:"+id+"」成功");
        }else {
            System.out.println("用户已存在");
        }
    }

    public static void main(String[] args) {
        MarketPractice marketPractice = new MarketPractice();
        marketPractice.createUser("zyt");
//        marketPractice.addItemToInventory(1,"adidas");
//        marketPractice.listItem(marketPractice.conn,"adidas",1,699);
    }

}
