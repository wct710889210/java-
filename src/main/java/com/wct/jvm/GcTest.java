package com.wct.jvm;

public class GcTest {
    private static int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] al1,al2,al3,al4;
        al1 = new byte[2*_1MB];
        al2 = new byte[2*_1MB];
        al3 = new byte[2*_1MB];
        al4 = new byte[2*_1MB];
    }
}
