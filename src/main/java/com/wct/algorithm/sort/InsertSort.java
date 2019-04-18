package com.wct.algorithm.sort;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * i表示要被插入的元素的位置，j表示插入的位置
     * @param nums
     */
    public static void sort(int[] nums){
        int j;
        int target;
        for(int i=1;i<nums.length;i++){     //假定第一个元素位置正确，将后面的元素插入
            j=i;
            target = nums[i];   //记录要被插入的值
            while (j>0&&nums[j-1]>target){   //找到正确的插入位置j
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        InsertSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
