package com.wct.basic;

/**
 * 测试浮点数在Java中的存储方式
 */
public class FloatTest {
    public static void main(String[] args) {
        float a = 1.10F;
        double b = 1.10;
        if (a == b){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
