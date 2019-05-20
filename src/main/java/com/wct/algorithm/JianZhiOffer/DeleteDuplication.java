package com.wct.algorithm.JianZhiOffer;

/**
 * 删除链表中重复的结点
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        boolean needDelete = false;
        ListNode now = pHead;
        ListNode pre = null;
        while(now.next != null){
            if(now.val == now.next.val){
                needDelete = true;
            }else{
                if(needDelete){
                    if(pre == null){
                        pHead = now.next;
                    }else{
                        pre.next = now.next;
                    }
                    needDelete = false;
                }else{
                    pre = now;
                }
            }
            now = now.next;
        }
        //链表尾部有重复元素
        if(needDelete){
            if(pre == null){
                pHead = now.next;
            }else{
                pre.next = now.next;
            }
        }
        return pHead;
    }
}
