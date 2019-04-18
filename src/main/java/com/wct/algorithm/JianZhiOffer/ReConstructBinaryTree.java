package com.wct.algorithm.JianZhiOffer;

/**
 * 根据前序序列和后序序列构建二叉树
 */
public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) throws Exception {
        if(pre == null || in == null || pre.length<=0 || in.length<=0){
            return null;
        }
        return reConstruct(pre,in,0,pre.length-1,0,in.length-1);
    }

    public static TreeNode reConstruct(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) throws Exception {
        TreeNode root = new TreeNode(pre[startPre]);
        root.left = null;
        root.right = null;

        if(startPre == endPre){
            if(startIn != endIn || root.val!=in[startIn])
                throw new Exception("输入序列不正确");
            else
                return root;
        }

        int rootIndex = startIn;
        while (rootIndex<=endIn && in[rootIndex]!=root.val)
            rootIndex++;
        if (rootIndex==endIn && in[rootIndex]!=root.val)
            throw new Exception("输入序列不正确");

        if(rootIndex>startIn){
            root.left = reConstruct(pre,in,startPre+1,startPre+rootIndex-startIn,startIn,rootIndex-1);
        }
        if (rootIndex<endIn){
            root.right = reConstruct(pre,in,endPre-(endIn-rootIndex)+1,endPre,rootIndex+1,endIn);
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        reConstructBinaryTree(pre,in);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
