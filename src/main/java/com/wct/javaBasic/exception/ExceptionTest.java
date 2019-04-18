package com.wct.javaBasic.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args){
        try {
            FileInputStream fileInputStream = new FileInputStream("/sdfsf");
        } catch (FileNotFoundException e) {
            System.out.println("e.getMessage():"+e.getMessage()+"\n文件没有找到");
        }
    }
}
