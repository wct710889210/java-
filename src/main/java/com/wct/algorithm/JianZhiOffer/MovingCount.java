package com.wct.algorithm.JianZhiOffer;

/**
 * 机器人的运动范围
 * 总结：要注意细节，要在一开始的时候就要确定一些细节的正确性，不然后面出错会很难发现错误的所在
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited = new boolean[rows*cols];
        return resolve(visited,threshold,rows,cols,0,0);
    }

    private int resolve(boolean[] visited, int threshold, int rows, int cols, int row, int col){
        int result = 0;
        if(row>=0 && col>=0 && row<rows && col<cols && !visited[row*cols+col] && canThreshold(row,col,threshold)){
            visited[row*cols+col] = true;
            result += 1;
            result += resolve(visited,threshold,rows,cols,row+1,col);
            result += resolve(visited,threshold,rows,cols,row-1,col);
            result += resolve(visited,threshold,rows,cols,row,col-1);
            result += resolve(visited,threshold,rows,cols,row,col+1);
        }
        return result;
    }

    /**
     * 是否符合k定义的条件
     * @param row   需要大于0
     * @param col   需要大于0
     * @return
     */
    private boolean canThreshold(int row, int col, int k){
        int result = 0;
        while (row != 0){
            result += row%10;
            row = row/10;
        }
        while (col != 0){
            result += col%10;
            col = col/10;
        }
        if (result <= k){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(15,100,1));
    }
}
