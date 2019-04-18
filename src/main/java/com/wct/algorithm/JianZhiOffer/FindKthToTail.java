package com.wct.algorithm.JianZhiOffer;

/**
 * 链表中倒数第k个结点
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k<=0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;

        for(int i=0;i<k-1;i++){
            if(second.next != null){
                second = second.next;
            }else{
                return null;
            }
        }

        while(second.next != null){
            first = first.next;
            second = second.next;
        }

        return first;
    }
}
