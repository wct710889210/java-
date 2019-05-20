package com.wct.javaBasic.concurrency.SynchronizationTool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ShuttingPractice {

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 5;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for(int i=0; i<nThreads; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"准备开始.......");
                        startGate.await();
                        System.out.println(Thread.currentThread().getName()+"运行完毕");
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        TimeUnit.MILLISECONDS.sleep(3000);
        startGate.countDown();
        endGate.await();
        System.out.println("任务全部结束");
    }

}
