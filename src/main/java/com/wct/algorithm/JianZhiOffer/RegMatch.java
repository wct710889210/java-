package com.wct.algorithm.JianZhiOffer;

/**
 * 正则表达式匹配
 */
public class RegMatch {
    public static boolean match(char[] str, char[] pattern)
    {
        if(str==null || pattern==null){
            return false;
        }
        return matchCore(str,0,pattern,0);
    }

    public static boolean matchCore(char[] str, int cursor1, char[] pattern, int cursor2){
        if(cursor1>=str.length && cursor2>=pattern.length){
            return true;
        }
        if(cursor1>=str.length){
            while(cursor2<=pattern.length-2 && pattern[cursor2+1]=='*'){
                cursor2+=2;
            }
            if(cursor2<pattern.length){
                return false;
            }else{
                return true;
            }
        }else if(cursor2>=pattern.length){
            return false;
        }
        if(cursor2==pattern.length-1 || pattern[cursor2+1]!='*'){
            if(pattern[cursor2]=='.' || str[cursor1]==pattern[cursor2]){
                return matchCore(str,cursor1+1, pattern, cursor2+1);
            }else {
                return false;
            }
        }else{
            if(str[cursor1]==pattern[cursor2] || pattern[cursor2]=='.'){
                return matchCore(str,cursor1+1, pattern, cursor2+2)||
                        matchCore(str,cursor1+1, pattern, cursor2)||
                        matchCore(str,cursor1, pattern, cursor2+2);
            }else {
                return matchCore(str,cursor1, pattern, cursor2+2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(match("aaa".toCharArray(),"ab*.ac*a".toCharArray()));
    }
}
