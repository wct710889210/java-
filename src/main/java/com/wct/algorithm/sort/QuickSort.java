package com.wct.algorithm.sort;

/**
 * 快速排序（升序排列）
 */
public class QuickSort {
    /**
     *
     * @param nums
     */
    public static void sort(int[] nums){
        recursion(nums,0,nums.length-1);
    }

    private static void recursion(int[] nums,int i,int j){
        if (j<=i)
            return;
        int base = i;   //基准值位置
        int tail = j;
        while (i < j){
            for(; j>i&&nums[j]>=nums[base]; j--);     //先移动j到小于基准值的位置
            for(; i<j&&nums[i]<=nums[base]; i++);     //再移动i到大于基准值的位置
            swap(nums,i,j); //交换两个元素
        }
        swap(nums,base,i);  //将基准值插入进来，形成左侧都小于基准值，右侧都大于基准值
        //继续递归求解
        recursion(nums,base,i-1);
        recursion(nums,i+1,tail);
    }

    private static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        QuickSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
