package com.wct.algorithm.JianZhiOffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class MinStack {
    private Stack<Integer> min = new Stack();
    private Stack<Integer> data = new Stack();

    public void push(int node) {
        if(min.size()==0 || node<min.peek())
            min.push(node);
        else
            min.push(min.peek());
        data.push(node);
    }

    public void pop() throws Exception{
        if(min.size()>0 && data.size()>0){
            min.pop();
            data.pop();
        }else {
            throw new Exception("当前栈没有元素");
        }
    }

    public int top() throws Exception{
        if (data.size()<=0)
            throw new Exception("当前栈没有元素");
        return data.peek();
    }

    public int min() throws Exception{
        if(min.size()<=0)
            throw new Exception("当前栈没有元素");
        return min.peek();
    }
}
