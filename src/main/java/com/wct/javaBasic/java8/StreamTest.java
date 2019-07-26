package com.wct.javaBasic.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        List<String> list2 = new ArrayList<>();
        list.stream().forEach((String i)->{list2.add(i);});
        System.out.println(list2);
    }
}
