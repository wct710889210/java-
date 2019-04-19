package com.wct.algorithm.JianZhiOffer;

/**
 * 链表中倒数第k个结点
 *
 * 总结：当算法求解时需要用到额外的存储空间时，需要确定所有的存储数据是否都有效，如果有无用的数据，不应该对其进行存储，
 * 这样可以降低算法的空间复杂度，如链表中倒数第k个结点问题中，我想用一个长度为k的数组来存储k个数据，当数组尾到达链表尾
 * 部时，数组头部就是第倒数第k个结点，但是数组中间的数据是无用的，可以用两个变量分别指向数组头尾对应的结点来进行空间优
 * 化.
 *
 * 注意数组的O(1)查询时间的利用
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
