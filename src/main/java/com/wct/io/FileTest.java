package com.wct.io;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader("/home/wct/实验一sql.txt")
        );
        String s;
        while ((s = reader.readLine()) != null){
            sb.append(s+"\n");
        }
        System.out.println(new String(sb.toString().getBytes(),"gbk"));
    }
}
