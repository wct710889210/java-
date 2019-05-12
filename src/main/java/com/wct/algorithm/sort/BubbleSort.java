package com.wct.algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 向前冒泡
     * @param nums
     */
    public static void sort(int[] nums){
        boolean isSorted;
        for(int i=nums.length-1; i>0; i--){
            System.out.println("one");
            isSorted = true;
            for(int j=0; j<i; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        BubbleSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
