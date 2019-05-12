package com.wct.algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length<=0){
            return null;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start= 0;
        while(start<=(rows-1)/2 && start<=(columns-1)/2){
            int endx = columns-1-start;
            int endy = rows-1-start;
            //向右
            for(int i=start;i<=endx;i++){
                result.add(matrix[start][i]);
            }
            //向下
            if(endy>start){
                for(int i=start+1;i<=endy;i++){
                    result.add(matrix[i][endx]);
                }
            }
            //向左
            if(endy>start && endx>start){
                for(int i=endx-1;i>=start;i--){
                    result.add(matrix[endy][i]);
                }
            }
            //向上
            if(endy>start+1 && endx>start){
                for(int i=endy-1;i>start;i--){
                    result.add(matrix[i][start]);
                }
            }
            start++;
        }
        return result;
    }
}
