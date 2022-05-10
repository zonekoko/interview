package com.zyp.interview.demo.algorithm.leetcode.hasPathSum;

import lombok.val;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点
 *
 * @Author zhangyanping
 * @Date 2022/5/5 17:15
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 广度优先遍历，两个队列，一个队列存放节点，一个队列存放跟节点到当前节点的值
     * @param root
     * @param targetNum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root,int targetNum){
        if(null == root){
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()){
            TreeNode curNode = nodeQueue.poll();
            Integer distance = sumQueue.poll();
            //说明是叶子节点
            if(null == curNode.left && null == curNode.right){
                if(distance == targetNum){
                    return true;
                }
                continue;
            }
            if(null != curNode.left){
                nodeQueue.offer(curNode.left);
                sumQueue.offer(distance + curNode.left.val);
            }
            if(null != curNode.right){
                nodeQueue.offer(curNode.right);
                sumQueue.offer(distance + curNode.right.val);
            }
        }
        return false;
    }

    /**
     * 递归，设根节点的值为x，判断有没有根节点到叶子节点的和为targetNum，
     * 就是判断有没有根节点的子节点到叶子节点的值为targetNum-x
     * @param root
     * @param targetNum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root,int targetNum){
        if(null == root){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetNum;
        }

        return hasPathSum2(root.left,targetNum - root.val)
                || hasPathSum2(root.right,targetNum - root.val);
    }

}
