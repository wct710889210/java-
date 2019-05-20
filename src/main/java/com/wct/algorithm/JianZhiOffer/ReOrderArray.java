package com.wct.algorithm.JianZhiOffer;

/**
 *  调整数组顺序使奇数位于偶数前面
 *  解题思路：https://www.cnblogs.com/xing901022/p/3755795.html
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if(array == null){
            return;
        }
        int length = array.length;
        int i = 0;
        int j = 0;
        int temp;
        while(i<length && j<length){
            while(i<length && (array[i]&1)!=0){
                i++;
            }
            j = i+1;
            while(j<length && (array[j]&1)==0){
                j++;
            }
            if(j<length){
                temp = array[j];
                for(int k=j; j>i; j--){
                    array[j] = array[j-1];
                }
                array[i] = temp;
                i = j;
            }
        }
    }
}
