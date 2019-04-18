package com.wct.algorithm.JianZhiOffer;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int start = 0;
        int end = array.length-1;
        int mid = start;
        while (array[start] >= array[end]){
            if(end-start==1){
                mid = end;
                break;
            }
            mid = (start+end)/2;

            if (array[mid] == array[start] && array[mid] == array[end]){
                int min = array[start];
                for (int i=start+1; i<=end; i++){
                    if (array[i]<min)
                        min=array[i];
                }
                return min;
            }

            if(array[mid] >= array[start]){
                start = mid;
            }else if(array[mid] <= array[end]){
                end = mid;
            }
        }
        return array[mid];
    }
}
