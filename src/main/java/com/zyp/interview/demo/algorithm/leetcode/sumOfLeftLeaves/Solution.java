package com.zyp.interview.demo.algorithm.leetcode.sumOfLeftLeaves;
//给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
//输入: root = [1]
//输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 470 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/7/5 15:21
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);

        TreeNode left = new TreeNode(-4);
        TreeNode right = new TreeNode(-3);

        TreeNode leftRight = new TreeNode(-1);
        TreeNode rightLeft = new TreeNode(8);



        TreeNode leftRightRight = new TreeNode(3);
        TreeNode rightLeftRight = new TreeNode(-9);

        leftRightRight.left = new TreeNode(-2);
        rightLeftRight.left = new TreeNode(4);

        leftRight.right = leftRightRight;
        rightLeft.right = rightLeftRight;

        left.right = leftRight;
        right.left = rightLeft;

        root.left = left;
        root.right = right;

        int sum = sumOfLeftLeaves(root);
        System.out.println(sum);

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        int sum = getSum(root);
        return sum;
    }

    public static int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        int sum = 0;
        sum +=  getSum(root.left);
        if(root.right != null && (root.right.left != null || root.right.right != null) ){
           sum +=  getSum(root.right);
        }
        return sum;
    }

}
