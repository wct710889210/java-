package com.wct.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        resolve(root,0);
        return result;
    }

    private void resolve(TreeNode node,int level){
        if(node == null) return;
        if(result.size()-1<level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        resolve(node.left,level+1);
        resolve(node.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        LevelOrder lo = new LevelOrder();
        lo.levelOrder(root);
    }
}
