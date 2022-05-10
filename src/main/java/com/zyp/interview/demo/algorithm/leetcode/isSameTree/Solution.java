package com.zyp.interview.demo.algorithm.leetcode.isSameTree;

/**
 * @ClassName Solution
 * @Description
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 * @Author zhangyanping
 * @Date 2022/4/29 10:21
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        root2.left = left2;
        root2.right = right2;

        boolean sameTree = isSameTree(root1, root2);
        System.out.println(sameTree);


    }

    public static boolean isSameTree(TreeNode p,TreeNode q){

        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        String s1 = treeToString(p, sb1);
        String s2 = treeToString(q, sb2);

        return s1.equals(s2);

    }

    public static String treeToString(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null|");
            return null;
        }
        sb.append(root.val + "|");
        treeToString(root.left,sb);
        treeToString(root.right,sb);
        return sb.toString();
    }
}
