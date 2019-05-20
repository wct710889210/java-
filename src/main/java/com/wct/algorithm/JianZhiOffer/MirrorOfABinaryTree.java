package com.wct.algorithm.JianZhiOffer;

import java.util.LinkedList;

/**
 * 二叉树的镜像,迭代方式求解
 */
public class MirrorOfABinaryTree {
    public void resolve(TreeNode root){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left==null && node.right==null){
                continue;
            }
            if (node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}