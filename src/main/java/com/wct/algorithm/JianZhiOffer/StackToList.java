package com.wct.algorithm.JianZhiOffer;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class StackToList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack2.empty()) {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            throw new Exception("当前队列没有元素");
        }
        return stack2.pop();
    }
}
