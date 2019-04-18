package com.wct.javaBasic.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    public <A,B,C> void f(A a,B b,C c){
        System.out.println(a.getClass().getName()+"----"+b.getClass().getName()+"----"+c.getClass().getName());
    }

    public static void main(String[] args) {
//        GenericMethods methods = new GenericMethods();
//        methods.f("哈哈哈",new Date(),new ArrayList<>());
        List<String> list = New.list();
        list.add("史蒂夫");
    }
}

class New{
    public static <T> List<T> list(){
        return new ArrayList<T>();
    }
}
