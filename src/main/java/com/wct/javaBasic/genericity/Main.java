package com.wct.javaBasic.genericity;

public class Main {
    public static void main(String[] args) {
        TwoTuple<String,Integer> tuple = new TwoTuple<>("王晨韬",21);
        System.out.println(tuple);
    }
}
