package com.wct.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉数先序、中序、后序遍历
 */
public class Traversal {
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        resolve(root);
        return result;
    }

    private void resolve(TreeNode node){
        if(node != null){
            result.add(node.val);       //先序、中序、后序就是调整遍历到自己的在遍历中的次序
            resolve(node.left);
            resolve(node.right);
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
