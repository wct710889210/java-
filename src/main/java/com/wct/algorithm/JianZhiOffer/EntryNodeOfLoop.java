package com.wct.algorithm.JianZhiOffer;

/**
 * 链表中环的入口结点
 */
public class EntryNodeOfLoop {
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        ListNode inLoop = null;
        int count = 0;
        ListNode temp;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1 == p2){
                inLoop = p1;
                break;
            }
        }

        //有环的情况
        if(inLoop != null){
            temp = inLoop.next;
            while (temp != inLoop){
                count++;
                temp = temp.next;
            }
            count++;

            p1 = pHead;
            p2 = pHead;
            for (int i=0; i<count; i++){
                p2 = p2.next;
            }
            while (p1!=p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(EntryNodeOfLoop(node1).val);
    }
}
