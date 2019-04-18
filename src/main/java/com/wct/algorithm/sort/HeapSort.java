package com.wct.algorithm.sort;

/**
 * 堆排序（以最大堆为例）
 */
public class HeapSort {
    /**
     * 堆排序(升序排列)
     */
    public void heapSort(int[] nums){
        HeapArray array = new HeapArray(nums);
        buildMaxHeap(array);
        while (array.heapSize > 1){
            swap(nums,1,array.heapSize);
            array.heapSize --;
            maxHeapify(array,1);
        }
    }

    /**
     * 维护最大堆性质
     * @param array 需要维护的最大堆（最大堆用数组方式表示）
     * @param i 进行维护的点,从1开始第i个元素，实际在数组中的坐标为i-1
     */
    private void maxHeapify(HeapArray array,int i){
        //left,right记录真实坐标，i，largest记录元素在第几个位置
        int largest = i;
        int left = 2*i -1;      //减1求的在数组中的相应坐标
        int right = 2*i+1-1;        //减1求的在数组中的相应坐标
        if(left<=array.heapSize-1 && array.nums[left]>array.nums[i-1])
            largest = left + 1;
        if(right<=array.heapSize-1 && array.nums[right]>array.nums[largest-1])
            largest = right + 1;
        if(largest != i) {
            //交换两个数
            swap(array.nums,i,largest);

            maxHeapify(array,largest);
        }
    }

    /**
     * 建立最大堆,用数组的形式表示一棵完全二叉树
     */
    private void buildMaxHeap(HeapArray array){

        for(int i=array.nums.length/2; i>=1; i--){
            maxHeapify(array,i);
        }
    }

    /**
     * 交换两个数组中的数
     * @param nums 数组
     * @param a 从1开始，第a个数
     * @param b 从1开始，第b个数
     */
    private void swap(int[] nums,int a,int b){
        //交换两个数
        int temp = nums[a - 1];
        nums[a - 1] = nums[b - 1];
        nums[b - 1] = temp;
    }

    /**
     * 最大堆数组
     */
    private class HeapArray{
        int[] nums;
        int heapSize;   //有效范围
        public HeapArray(int[] nums){
            this.nums = nums;
            heapSize = nums.length;
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
//        heapSort.heapSize = 10;
        int[] nums = new int[]{15,5,36,59,422,15,1,6,89};
        heapSort.heapSort(nums);
        for (int i:nums)
            System.out.print(i+",");
    }
}
