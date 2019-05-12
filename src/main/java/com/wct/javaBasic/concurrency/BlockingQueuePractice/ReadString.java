package com.wct.javaBasic.concurrency.BlockingQueuePractice;

import java.util.concurrent.BlockingQueue;

public class ReadString implements Runnable{
    private final BlockingQueue<String> stringQueue;

    public ReadString(BlockingQueue<String> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName()+"(get):"+stringQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
