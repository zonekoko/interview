package com.zyp.interview.demo.algorithm.leetcode.inorderTraversal;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/29 09:20
 * @Version 1.0
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
