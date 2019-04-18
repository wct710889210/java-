package com.wct.algorithm;

/**
 * 验证回文串
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<=j){
            if(i == j){
                break;
            }
            if(!isIn(chars[i])){
                i++;
            }
            if(!isIn(chars[j])){
                j--;
            }
            if(isIn(chars[i]) && isIn(chars[j])){
                if(chars[i] != chars[j]){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isIn(char c){
        boolean result = false;
        if(c>=48&&c<=57 || c>=65&&c<=90 || c>=97&&c<=122){
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        IsPalindrome resolve = new IsPalindrome();

        System.out.println(resolve.isPalindrome(".,"));
    }
}
