package com.wct.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    /**
     * 升序排列
     * @param nums
     */
    public static void sort(int[] nums){
        int min;
        int temp;
        for (int i=0;i<nums.length-1;i++){
            min = i;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[min])
                    min = j;
            }
            temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        SelectionSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
