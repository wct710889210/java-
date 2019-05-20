package com.wct.javaBasic.concurrency.ExecutorPractice;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(1000);
//                throw new Exception("mock exception");
                return "finish";
            }
        };
        Thread.currentThread().interrupt();
        Future<String> future = executor.submit(callable);
        while(!future.isDone()){
            System.out.println("任务进行中。。。。。。");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("等待中断");
            }
        }
        String result = "";
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("任务发生异常");
        }
        System.out.println("任务完成，返回结果："+result);
    }
}
