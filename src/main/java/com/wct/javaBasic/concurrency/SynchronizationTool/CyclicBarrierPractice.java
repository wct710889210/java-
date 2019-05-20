package com.wct.javaBasic.concurrency.SynchronizationTool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierPractice {
    public static void main(String[] args) {
        int threadCount = 3;
        final CyclicBarrier barrier = new CyclicBarrier(threadCount);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"准备开始执行任务");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()+"执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        };
        for(int i=0; i<threadCount; i++){
            new Thread(task).start();
        }
    }
}
