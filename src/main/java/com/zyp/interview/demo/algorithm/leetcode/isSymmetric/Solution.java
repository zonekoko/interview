package com.zyp.interview.demo.algorithm.leetcode.isSymmetric;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @Author zhangyanping
 * @Date 2022/5/3 10:24
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(2);
//        root.left = left;
//        root.right = right;
//
//        left.left = new TreeNode(3);
//        left.right = new TreeNode(4);
//
//        right.left = new TreeNode(4);
//        right.right = new TreeNode(3);

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        left.left = new TreeNode(2);

        right.left = new TreeNode(2);



        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);


    }

    public static boolean isSymmetric(TreeNode root){
        return check2(root,root);
    }

    /**
     * 思路：利用递归同时判断两棵子树，判断是否对称
     * @param p
     * @param q
     * @return
     */
    public static boolean check1(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && check1(p.left,q.right) && check1(p.right,q.left);
    }

    /**
     * 利用队列同时判断两个子树是否对称
     * @param u
     * @param v
     * @return
     */
    public static boolean check2(TreeNode u,TreeNode v){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);

        while (!queue.isEmpty()){
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            if(poll1 == null && poll2 == null){
                continue;
            }
            if(poll1 == null || poll2 == null || poll1.val != poll2.val){
                return false;
            }

            queue.offer(poll1.left);
            queue.offer(poll2.right);

            queue.offer(poll1.right);
            queue.offer(poll2.left);
        }
        return true;
    }




}
