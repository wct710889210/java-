package com.wct.javaBasic.concurrency.BlockingQueuePractice;

import java.util.concurrent.BlockingQueue;

public class PutString implements Runnable{
    private final BlockingQueue<String> stringQueue;

    public PutString(BlockingQueue<String> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public void run(){
        try{
            for (int i=0;i<10;i++){
                stringQueue.put(Thread.currentThread().getName()+"(putted)"+i);
                System.out.println(Thread.currentThread().getName()+"(putted)"+i);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
