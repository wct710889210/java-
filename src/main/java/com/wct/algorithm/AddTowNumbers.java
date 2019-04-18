package com.wct.algorithm;

//两数相加

//例子
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807

public class AddTowNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean up = false;
        ListNode result = null;
        ListNode temp = null;
        ListNode notNull;
        int sum;

        while (l1 != null && l2 != null){
            sum = 0;

            //如果有进位
            if(up){
                sum++;
                up = false;
            }

            sum += l1.val + l2.val;

            //相加大于9,需要进位
            if(sum > 9){
                sum -= 10;
                up = true;
            }

            if (result == null){
                result = new ListNode(sum);
                temp = result;
            }
            else{
                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            //移位
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1!=null)
            notNull = l1;
        else
            notNull = l2;

        while (notNull != null){
            sum = 0;
            if(up){
                sum++;
                up = false;
            }
            sum += notNull.val;

            //相加大于9,需要进位
            if(sum > 9){
                sum -= 10;
                up = true;
            }

            temp.next = new ListNode(sum);
            temp = temp.next;

            notNull = notNull.next;
        }
        if (up)
            temp.next = new ListNode(1);

        return result;
    }

    public static void printNum(ListNode num){
        while (num != null){
            System.out.print(num.val+"->");
            num = num.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        printNum(l1);
        System.out.println();
        printNum(l2);
        System.out.println();

        printNum(addTwoNumbers(l1,l2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
