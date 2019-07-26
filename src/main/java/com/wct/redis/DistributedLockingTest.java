package com.wct.redis;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DistributedLockingTest {


    public static void main(String[] args) {
        DistributedLockingTest test = new DistributedLockingTest();
        try {
            test.testDistributedLocking(ConnectionFactory.getConn());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void testDistributedLocking(Jedis conn)
            throws InterruptedException
    {
        System.out.println("\n----- testDistributedLocking -----");
        conn.del("lock:testlock");
        System.out.println("Getting an initial lock...");
        assert acquireLockWithTimeout(conn, "testlock", 1000, 1000) != null;
        System.out.println("Got it!");
        System.out.println("Trying to get it again without releasing the first one...");
        assert acquireLockWithTimeout(conn, "testlock", 10, 1000) == null;
        System.out.println("Failed to get it!");
        System.out.println();

        System.out.println("Waiting for the lock to timeout...");
        Thread.sleep(2000);
        System.out.println("Getting the lock again...");
        String lockId = acquireLockWithTimeout(conn, "testlock", 1000, 1000);
        assert lockId != null;
        System.out.println("Got it!");
        System.out.println("Releasing the lock...");
        assert releaseLock(conn, "testlock", lockId);
        System.out.println("Released it...");
        System.out.println();

        System.out.println("Acquiring it again...");
        assert acquireLockWithTimeout(conn, "testlock", 1000, 1000) != null;
        System.out.println("Got it!");
        conn.del("lock:testlock");
    }

    public String acquireLock(Jedis conn, String lockName) {
        return acquireLock(conn, lockName, 10000);
    }

    public String acquireLock(Jedis conn, String lockName, long acquireTimeout){
        String identifier = UUID.randomUUID().toString();
        long end = System.currentTimeMillis()+acquireTimeout;
        while(System.currentTimeMillis()<end){
            if(conn.setnx("lock:"+lockName,identifier)==1){
                return identifier;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    public String acquireLockWithTimeout(Jedis conn, String lockName, long acquireTimeout, long lockTimeout){
        String identifier = UUID.randomUUID().toString();
        String lockKey = "lock:"+lockName;
        int lockExpire = (int)(lockTimeout / 1000);
        long end = System.currentTimeMillis()+acquireTimeout;
        while(System.currentTimeMillis()<end){
            if(conn.setnx(lockKey,identifier)==1){
                conn.expire(lockKey,lockExpire);
                return identifier;
            }
            if(conn.ttl(lockKey)==-1){
                conn.expire(lockKey,lockExpire);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    public boolean releaseLock(Jedis conn, String lockName, String identifier) {
        String lockKey = "lock:" + lockName;
        conn.watch(lockKey);
        while (true) {
            if (identifier.equals(conn.get(lockKey))) {
                Transaction tras = conn.multi();
                tras.del(lockKey);
                List<Object> results = tras.exec();
                if (results == null) {
                    continue;
                }
                return true;
            }
            conn.unwatch();
            break;
        }
        return false;
    }
}
