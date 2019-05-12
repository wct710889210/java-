package com.wct.javaBasic.concurrency.BlockingQueuePractice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> stringQueue = new LinkedBlockingDeque<>();
        for (int i=0;i<5;i++){
            new Thread(new PutString(stringQueue)).start();
            new Thread(new ReadString(stringQueue)).start();
        }
    }
}
