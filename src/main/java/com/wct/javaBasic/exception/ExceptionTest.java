package com.wct.javaBasic.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args) throws Exception{
        System.out.println("异常之前");
        runtimeExceptionMethod(false);
//        checkedExceptionMethod();
        System.out.println("异常之后");
    }

    private static void runtimeExceptionMethod(boolean doThrow){
        if(doThrow){
            throw new RuntimeException();
        }
//        System.out.println("after RuntimeException");     运行时异常后无法运行任何代码
    }

    private static void checkedExceptionMethod() throws Exception{
        throw new Exception();
//        System.out.println("after RuntimeException");     只有捕获后才可以继续运行
    }
}
