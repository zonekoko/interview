package com.zyp.interview.demo.algorithm.leetcode.inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @Author zhangyanping
 * @Date 2022/4/29 09:19
 * @Version 1.0
 */
public class Solution {

    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right =  new TreeNode(2);

        root.right = right;
        right.left = new TreeNode(3);

        List<Integer> integers = inorderTraversal(root);

        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
