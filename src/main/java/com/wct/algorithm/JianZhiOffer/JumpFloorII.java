package com.wct.algorithm.JianZhiOffer;

/**
 * 变态跳台阶
 */
public class JumpFloorII {
    public int JumpFloorII(int target) throws Exception{
        if(target<0)
            throw new Exception("参数错误");
        if(target == 0)
            return 0;
        return (int)Math.pow(2,target-1);
    }
}
