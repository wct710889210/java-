package com.wct.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) throws IOException {
        //可写的channel
        //创建FileOutPutStream时会把原来重名的文件删除重新创建文件
        FileChannel fc = new FileOutputStream("/home/wct/Projects/IdeaProject/TestData/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("我是谁".getBytes()));
        fc.close();

        //可读可写的channel
        fc = new RandomAccessFile("/home/wct/Projects/IdeaProject/TestData/data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        //可读的channel
        fc = new FileInputStream("/home/wct/Projects/IdeaProject/TestData/data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
    }
}
