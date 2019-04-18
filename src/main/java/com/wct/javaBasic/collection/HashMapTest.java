package com.wct.javaBasic.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        String a = new String("aaa");
        System.out.println("System.identityHashCode(a):"+System.identityHashCode(a));
        System.out.println("a.hashCode():"+a.hashCode());
    }
}
