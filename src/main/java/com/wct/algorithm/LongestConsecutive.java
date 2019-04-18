package com.wct.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    Map<Integer,Integer> input = new HashMap<>();
    Map<Integer,Integer> max = new HashMap<>();
    int maxLength = 0;

    public int longestConsecutive(int[] nums) {
        for(int num:nums){
            input.put(num,0);
        }
        for(int num:nums){
            resolve(num);
        }
        return maxLength;
    }

    private int resolve(int num){
        if(max.containsKey(num)){
            return max.get(num);
        }else {
            if(!input.containsKey(num)){
                return 0;
            }else {
                int temp = resolve(num-1)+1;
                max.put(num,temp);
                if(temp > maxLength){
                    maxLength = temp;
                }
                return temp;
            }
        }
    }

    public int longestConsecutive2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = 1;
        int length = 1;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1] != nums[i]) {
                if (nums[i + 1] == nums[i] + 1) {
                    length++;
                } else {
                    length = 1;
                }
                if (length > max)
                    max = length;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int result = new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        int result = new LongestConsecutive().longestConsecutive2(new int[]{1,2,0,1});
        System.out.println(result);
    }
}
