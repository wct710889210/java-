package com.wct.algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();     //创建一个栈
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.size() != 0){
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
