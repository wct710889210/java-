package com.wct.algorithm.JianZhiOffer;

/**
 * 二位数组中的查找
 */
public class FindingInBinaryArray {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length<=0)
            return false;
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns-1;
        while (row<rows && column>=0){
            int temp = array[row][column];
            if(target == temp)
                return true;
            else if (target > temp)
                row++;
            else
                column--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Find(7,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
    }
}
