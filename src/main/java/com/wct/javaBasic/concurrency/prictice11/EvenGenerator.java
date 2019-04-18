package com.wct.javaBasic.concurrency.prictice11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenGenerator {
    private int currnetEvenValue = 0;
    private boolean isCancel = false;

    public synchronized int next(){
        ++currnetEvenValue;

        Thread.yield();     //促进出发非正常情况

        ++currnetEvenValue;
        return currnetEvenValue;
    }

    public boolean isCancel(){
        return this.isCancel;
    }

    public void cancel(){
        this.isCancel = true;
    }

    public static void main(String[] args) {
        EvenGenerator generator = new EvenGenerator();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=1;i<5;i++){
            executorService.execute(new EvenChecker(generator));
        }
        executorService.shutdown();
    }
}
