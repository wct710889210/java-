package com.wct.algorithm;

import java.util.HashMap;
import java.util.Map;

//两数之和问题
public class TowSum {
//    暴力法
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            int need = target - nums[i];
            for (int j = i+1;j<nums.length;j++){
                if (nums[j]==need)
                    return new int[]{i,j};
            }
        }
        return null;
    }

//    利用哈希表
    public int[] answer(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{i,map.get(need)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
