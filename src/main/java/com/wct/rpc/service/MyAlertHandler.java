package com.wct.rpc.service;

public class MyAlertHandler {
    public void handleAlert(String msg){
        System.out.print("message received:"+msg+" from queue\n");
    }
}
