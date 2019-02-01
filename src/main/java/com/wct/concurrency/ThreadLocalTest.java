package com.wct.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    private static ThreadLocal<String> testInfo = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "现在的线程是"+Thread.currentThread().getName();
        }
    };

    private static class PrintThreadLocal extends Thread{
        @Override
        public void run() {
            System.out.println(testInfo.get());
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<5;i++){
            new PrintThreadLocal().start();
        }
    }

}


