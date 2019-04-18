package com.wct.algorithm.JianZhiOffer;

/**
 * 矩阵中的路径
 */
public class HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] used = new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (resolve(used,matrix,rows,cols,i,j,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param used
     * @param matrix
     * @param rows
     * @param cols
     * @param row   选择的点的纵坐标
     * @param col   选择的点的横坐标
     * @param str
     * @param n
     * @return
     */
    private static boolean resolve(boolean[] used, char[] matrix, int rows, int cols, int row, int col, char[] str, int n){
        //todo 还需要改善
        //应该将需要回溯的情况一起进行回溯，即当前结点不符合条件时和对后续结点的访问都不符合条件时
        if (n>str.length-1){
            return true;
        }
        int position = row*cols+col;
        if (row<0 || col>cols-1 || row>rows-1 || col <0 || used[position] || matrix[position]!=str[n]){
            return false;   //回溯
        }
        used[position] = true;
        boolean isPath = resolve(used, matrix, rows, cols, row-1, col, str, n+1) ||
                resolve(used, matrix, rows, cols, row+1, col, str, n+1) ||
                resolve(used, matrix, rows, cols, row, col-1, str, n+1) ||
                resolve(used, matrix, rows, cols, row, col+1, str, n+1);
        if(!isPath){
            used[position] = false;     //回溯
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if(hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray())){
            System.out.println(true);
        }
    }
}
