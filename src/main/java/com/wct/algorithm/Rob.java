package com.wct.algorithm;

/**
 * 打家劫舍
 */
public class Rob {
    int[][] note;
    int[] note2;     //第二种解法的记录数组

    public int rob(int[] nums) {
        return resolve(nums);
    }

    /**
     * 自己想的方法，用两个参数来描述问题域，效率低，注意尽量用少的变量来描述问题域
     * m(i,j)=max(m(i-2,j-2),m(i-2,j-3),m(i-3,j-2),m(i-3,j-3))
     * @param nums
     * @param i
     * @param j
     * @return
     */
    @Deprecated
    private int resolve(int[] nums,int i,int j){
        if(i > j){
            return 0;
        }else if(i == j){
            return nums[i];
        }else if(j - i == 1){
            return nums[i]>nums[j]?nums[i]:nums[j];
        }else {
            if(i != -2 && j != nums.length+1 && note[i][j] != 0){
                return note[i][j];
            }
            int max = 0;
            int temp;
            for (int k=2;k<=3;k++){
                for (int l=2;l<=3;l++){
                    temp = resolve(nums,i+k,j-l);
                    if (temp > max)
                        max = temp;
                }
            }
            if(i==-2 && j==nums.length+1){
                return max;
            }else {
                int result = max + nums[i] + nums[j];
                note[i][j] = result;
                return result;
            }
        }
    }

    /**
     * 一种更好的解法，使用一个变量描述问题域：
     *      m(i)=max(m(i-2)+num[i],m(i-1))
     * m(i)表示到i为止最大的和
     * 利用最优解的性质：最后两个数必定选择一个，但不能确定选择哪个，所以求两种情况的最大值
     * @param nums
     * @param i
     * @return
     */
    private int resolve(int[] nums,int i){
        if(nums.length <= 0){
            return 0;
        }else {
            if(note2[i] != -1){
                return note2[i];
            } else if(i == 0){
                note2[0] = nums[0];
                return nums[0];
            }else if(i == 1){
                note2[1] = Math.max(nums[0],nums[1]);
                return note2[1];
            }else {
                note2[i] = Math.max(resolve(nums,i-2)+nums[i],resolve(nums,i-1));
                return note2[i];
            }
        }
    }

    /**
     * 采用非递归形式，是一种更加优的解法
     * @param nums
     * @return
     */
    private int resolve(int[] nums){
        int prepre = 0;
        int pre = 0;
        for (int k=0;k<nums.length;k++){
            if(k == 0){
                pre = prepre = nums[0];
            }else if (k == 1){
                pre = Math.max(nums[0],nums[1]);
            }else {
                int temp = Math.max(prepre + nums[k],pre);
                prepre = pre;
                pre = temp;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1,2,3,1}));
    }
}
