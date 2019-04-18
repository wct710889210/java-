package com.wct.algorithm.sort;

/**
 * 归并排序（升序排列）
 */
public class MergeSort {

    public static void sort(int[] nums){
        recursion(nums, 0, nums.length-1);
    }

    /**
     * 递归求解
     * @param nums
     * @param left
     * @param right
     */
    public static void recursion(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            recursion(nums,left,mid);
            recursion(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    /**
     * 将c[l,m]与c[m+1,r]合并
     * @param nums
     * @param l 左数组起始位置
     * @param m 左数组结束位置
     * @param r 右数组结束位置
     */
    public static void merge(int[] nums,int l,int m,int r){
        int i = l;
        int j = m+1;
        int t = 0;
        int[] temp = new int[r-l+1];
        while(i<=m && j<=r){        //遍历左右两数组，将较小的元素放入临时数组
            if(nums[i]<nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }
        if(i > m){      //说明左数组的元素全放进临时数组了，这时将右数组剩余的元素放入临时数组
            while (j<=r){
                temp[t++] = nums[j++];
            }
        }else {     //说明右数组的元素全放进临时数组了，这时将左数组剩余的元素放入临时数组
            while (i<=m){
                temp[t++] = nums[i++];
            }
        }
        //从临时数组复制回原数组
        for(i=l,t=0; i<=r; ){
            nums[i++] = temp[t++];
        }
    }

    //todo 迭代方式进行归并排序
    public void iterationSort(){

    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        MergeSort.sort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
