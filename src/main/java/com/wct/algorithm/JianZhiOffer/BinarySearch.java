package com.wct.algorithm.JianZhiOffer;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 二分查找
     * @param input     被查找的数组
     * @param search    要查找的数
     * @return      要找的数所在的坐标
     */
    public static int binarySearch(int[] input,int search){
        int start = 0;
        int end = input.length-1;
        while(end>=start){
            int mid = (start+end)/2;
            if(input[mid] == search){
                return mid;
            }else if(search >input[mid]){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1,5,6,11,18,56,77,106,209};
        int search = 1111;
        System.out.println("index="+binarySearch(input,search));
    }
}
