package com.wct.javaBasic.collection;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class CollectionTest {
    public static void main(String[] args) {
        Collection collection = Arrays.asList(new int[]{1,2,3,4,5,6,7,8,9});
//        collection.add(1);
        System.out.println(collection.getClass().getName());
    }
}
