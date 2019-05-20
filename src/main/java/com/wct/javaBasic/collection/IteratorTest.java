package com.wct.javaBasic.collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
//        useIteratro();
        testDelete();
    }

    private static void testDelete(){
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        Iterator<Integer> iterator = list.iterator();
        list.remove(1);     //改变了容器的大小
        iterator.next();    //改变了容器的大小后再使用之前的迭代器，将导致出错
    }

    /**
     * Iterator的使用
     */
    private static void useIteratro(){
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == 3){
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }
}
