package com.zyp.interview.demo.algorithm.leetcode.maxDepth;

import io.swagger.models.auth.In;
import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author zhangyanping
 * @Date 2022/5/3 14:26
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.left = new TreeNode();

        int i = maxDepth(root);
        System.out.println(i);
    }

    public static int maxDepth1(TreeNode root){
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> resultMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Integer level = 1;

        Integer maxLevel = 0;

        resultMap.put(root,level);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            Integer curLevel = resultMap.get(curNode);
            maxLevel = curLevel;
            if(curNode.left != null){
                resultMap.put(curNode.left,curLevel + 1);
                queue.offer(curNode.left);
            }
            if (curNode.right != null){
                resultMap.put(curNode.right,curLevel + 1);
                queue.offer(curNode.right);
            }
        }
        return maxLevel;
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLevel = maxDepth(root.left);
        int rightLevel = maxDepth(root.right);

        return Math.max(leftLevel,rightLevel) + 1;
    }
}
