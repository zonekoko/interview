package com.zyp.interview.demo.algorithm.leetcode.minDepth;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * @Author zhangyanping
 * @Date 2022/5/5 16:37
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        //3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        root.left = left;
        root.right = right;

        right.left = new TreeNode(15);
        right.right =  new TreeNode(7);

        int depth = minDepth(root);
        System.out.println(depth);

    }

    public static int minDepth(TreeNode root){
        if(null == root){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode element = queue.poll();
                if (null == element.left && null == element.right) {
                    return ans;
                }
                if(element.left != null){
                    queue.offer(element.left);
                }
                if(element.right != null){
                    queue.offer(element.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
