package com.wct.algorithm.sort;

public class ShellSort {

    public static void sort(int[] nums){
        sort2(nums,0,nums.length-1);
    }

    public static void sort2(int[] nums,int l,int r){
        int h;
        for(h=1; h<=(r-1)/9; h=3*h+1);      //确定初始步长

        for(;h>0;h=h/3){        //改变步长
            for (int i=l+h; i<=r; i++){     //按顺序移动元素
                int j = i;
                int value = nums[j];
                while(j>=l+h && nums[j-h]>=value){
                    nums[j] = nums[j-h];
                    j-=h;
                }
                nums[j] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        ShellSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
