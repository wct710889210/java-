package com.wct.algorithm;

import com.rabbitmq.client.Return;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstring {
    int[][] m;

    public int longestSubstring(String s, int k) {
        int size = s.length();
        m = new int[size][size];
        return recursion(s,k,0,size-1);
    }

    public int recursion(String s,int k,int i,int j){
        if(i > j){
            return 0;
        }
        if(m[i][j] != 0){
            return m[i][j];
        }else {
            List<Integer> not = getPos(s.substring(i,j+1),k);
            if(not.isEmpty()){
                m[i][j] = j-i+1;
                return m[i][j];
            }else {
                int max = recursion(s,k,i,i+not.get(0)-1);
                not.add(j+1-i);
                for(int a = 0;a < not.size()-1;a++){
                    int temp = recursion(s,k,i+not.get(a)+1,i+not.get(a+1)-1);
                    if(temp>max)
                        max = temp;
                }
                m[i][j] = max;
                return max;
            }
        }
    }


    public List<Integer> getPos(String s,int k) {
        char[] cs = s.toCharArray();
        Map<Character,Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();

//        统计
        for(char c:cs){
            if(count.containsKey(c))
                count.put(c,count.get(c)+1);
            else
                count.put(c,1);
        }

        for(int i=0;i<cs.length;i++){
            if(count.get(cs[i]) < k)
                result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().longestSubstring("ababacb",3));
    }

}
