package com.zyp.interview.demo.algorithm.leetcode.invertTree;
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/20 13:11
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);

        root.left = left;
        root.right = right;

        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        TreeNode treeNode = invertTree2(root);
        System.out.println(treeNode);
    }

    public static TreeNode invertTree1(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTree2(TreeNode root){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            poll.left = poll.right;
            poll.right = left;

            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
        return root;
    }

}
