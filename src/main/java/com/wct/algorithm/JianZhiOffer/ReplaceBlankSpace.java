package com.wct.algorithm.JianZhiOffer;

/**
 *  替换空格
 */
public class ReplaceBlankSpace {
    public static String replaceSpace(StringBuffer str) {
        int originalLength = str.length();
        int numberOfBlank = 0;
        for (int i=0;i<originalLength;i++){
            if(str.charAt(i) == ' '){
                numberOfBlank ++;
            }
        }
        int indexOfstr = originalLength-1;
        int newLength = originalLength + numberOfBlank*2;
        int indexOfNew = newLength - 1;
        str.setLength(newLength);   //设置新的字符数组长度
        while(indexOfNew>indexOfstr){
            if(str.charAt(indexOfstr) == ' '){
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
            }else {
                str.setCharAt(indexOfNew--,str.charAt(indexOfstr));
            }
            indexOfstr--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We are happy")));
    }
}
