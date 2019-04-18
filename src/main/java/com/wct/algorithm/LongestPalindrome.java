package com.wct.algorithm;

//最长回文子串
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s.equals(""))
            return "";

        int size = s.length();
        boolean[][] m = new boolean[size][size];
        int maxI = 0;
        int maxJ = 0;

        for (int i = 0;i < size;i++){
            m[i][i] = true;
        }
        for(int i = 1;i < size;i++){
            for (int j = 0;j < size - i;j++){
                int x = j;
                int y = j+i;
                boolean temp = x+1>y-1?true:m[x+1][y-1];
                m[x][y] = temp && (s.charAt(x) == s.charAt(y));

                //记录最大回文字串位置
                if(m[x][y] && (maxJ-maxI)<(y-x)){
                    maxI = x;
                    maxJ = y;
                }
            }
        }

        return s.substring(maxI,maxJ+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println("".length());
    }
}
