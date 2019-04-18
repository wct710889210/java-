package com.wct.algorithm;

import java.util.HashMap;

/**
 * 二叉树中的最大路径和
 *
 * 我的解法：m(node)=max((max(maxDown(node.left),maxDown(node.right),0)+node.val),m(node.left),m(node.right))
 */
public class MaxPathSum {
    HashMap<TreeNode,Integer> maxDown;

    public int maxPathSum(TreeNode root) {
        maxDown = new HashMap<>();
        return resolve(root);
    }

    public Integer resolve(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return node.val;
        }else {
            int left = getMaxDown(node.left);
            int right = getMaxDown(node.right);
            int max = (left>0?left:0) + (right>0?right:0) + node.val;
            Integer leftMax = resolve(node.left);
            Integer rightMax = resolve(node.right);

            if(leftMax!=null && leftMax > max)
                max = leftMax;
            if (rightMax!=null && rightMax > max)
                max = rightMax;
            return max;
        }
    }

    public int getMaxDown(TreeNode node){
        if(node == null){
            return -1;
        }
        if(maxDown.containsKey(node)){
            return maxDown.get(node);
        }
        if(node.left == null && node.right == null){
            maxDown.put(node,node.val);
            return node.val;
        }else {
            int result = node.val;
            int left = getMaxDown(node.left);
            int right = getMaxDown(node.right);
            int max = left>right?left:right;
            if(max>0){
                result+=max;
            }
            maxDown.put(node,result);
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        MaxPathSum resolve = new MaxPathSum();
        System.out.println(resolve.maxPathSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

/**
 * 大牛的解法
 */
class Solution {

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;   //注意这里返回的是从该结点向下搜索的最大路径和，但上面的ret记录了最大路径和，将我
                                                //的算法中的两个递归结合在了一起，值得学习
    }
}
