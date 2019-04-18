package com.wct.javaBasic.concurrency.prictice3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prictice3 {
    public static void main(String[] args) {
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++){
            //使用线程池，线程都会复用
//            cachedExecutor.execute(new Run("线程"+i+"开始","线程"+i+"结束",i));       //线程调度具有随机性
//            singleExecutor.execute(new Run("线程"+i+"开始","线程"+i+"结束",i));     //只有一个线程在运行
            fixedExecutor.execute(new Run("线程"+i+"开始","线程"+i+"结束",i));
        }
//        cachedExecutor.shutdown();
//        singleExecutor.shutdown();
        fixedExecutor.shutdown();
    }
}

class Run implements Runnable{

    private String start;
    private String stop;
    private int id;

    public Run(String start, String stop,int id){
        this.start = start;
        this.stop = stop;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(start);

        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+":id("+id+")");
            Thread.currentThread().yield();
        }

        System.out.println(stop);
    }
}
