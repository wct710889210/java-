package com.wct.algorithm.sort;

/**
 * 用于练习排序算法
 */
public class Practice {

    private static void bubbleSort(int[] nums){
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

    public static void SelectionSort(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            int minPos = i;
            for(int j = i+1; j<nums.length; j++){
                if(nums[j]<nums[minPos]){
                    minPos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }
    }

    public static void insertSort(int[] nums){
        int target;
        int j;
        for(int i=1; i<nums.length; i++){
            target = nums[i];
            j = i;
            while(j>0 && nums[j-1]>target){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = target;
        }
    }

    public static void quickSort(int[] nums){
        recursion(nums,0,nums.length-1);
    }

    private static void recursion(int[] nums,int i,int j){
        if(i>=j){
            return;
        }
        int base = i;
        int tail = j;
        while(i<j){
            for(; j>i && nums[j]>=nums[base]; j--);
            for(; i<j && nums[i]<=nums[base]; i++);
            swap(nums,i,j);
        }
        swap(nums,base,i);

        recursion(nums,base,i-1);
        recursion(nums,i+1,tail);
    }

    private static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void quickSort2(int[] nums){

    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        int[] nums2 = new int[]{2,1,3,4,5,6,7,8,9,10};  //记本有序的情况，更快
//        bubbleSort(nums);
//        SelectionSort(nums);
//        insertSort(nums);
        quickSort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
