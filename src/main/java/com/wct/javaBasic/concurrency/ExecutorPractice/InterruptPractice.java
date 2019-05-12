package com.wct.javaBasic.concurrency.ExecutorPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 如果一个线程处于了阻塞状态（如线程调用了thread.sleep、thread.join、thread.wait、1.5中的condition.await、
 * 以及可中断的通道上的 I/O 操作方法后可进入阻塞状态），则在线程在检查中断标示时如果发现中断标示为true，则
 * 会在这些阻塞方法（sleep、join、wait、1.5中的condition.await及可中断的通道上的 I/O 操作方法）调用处抛出
 * InterruptedException异常，并且在抛出异常后立即将线程的中断标示位清除，即重新设置为false。抛出异常是为了
 * 线程从阻塞状态醒过来，并在结束线程前让程序员有足够的时间来处理中断请求。
 */
public class InterruptPractice {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println("发生中断");
                        System.out.println("中断标志位："+Thread.currentThread().isInterrupted());    //显示为false
                    }
                System.out.println("任务结束");
            }
        });
        thread.start();
        thread.interrupt();     //进行中断
    }
}
