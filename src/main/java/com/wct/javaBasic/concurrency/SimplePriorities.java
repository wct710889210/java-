package com.wct.javaBasic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class SimplePriorities implements Runnable{

    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    @Override
    public void run() {
        while(true){
            try {
                //通过获取当前线程来设置优先级
                Thread.currentThread().setPriority(priority);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+"--"+Thread.currentThread().getPriority()+"--"+this);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool(new PriorityThreadFactory());
        for(int i=0;i<3;i++)
            executor.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        for(int i=0;i<3;i++)
            executor.execute(new SimplePriorities(Thread.NORM_PRIORITY));
        for(int i=0;i<3;i++)
            executor.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executor.shutdown();
        System.out.println("All Started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

class PriorityThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
