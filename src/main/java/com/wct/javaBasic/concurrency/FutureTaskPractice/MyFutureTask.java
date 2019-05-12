package com.wct.javaBasic.concurrency.FutureTaskPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyFutureTask<V> extends FutureTask<V> {

    public MyFutureTask(Callable<V> callable) {
        super(callable);
    }

    public MyFutureTask(Runnable runnable, V result) {
        super(runnable, result);
    }

    @Override
    protected void done() {
        System.out.println("任务完成");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(new MyFutureTask<Void>(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了任务");
            }
        },null));
    }
}
