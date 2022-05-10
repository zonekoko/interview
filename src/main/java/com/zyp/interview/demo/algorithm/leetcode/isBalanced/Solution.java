package com.zyp.interview.demo.algorithm.leetcode.isBalanced;

/**
 * @ClassName Solution
 * @Description
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @Author zhangyanping
 * @Date 2022/5/4 15:52
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {


        //[1,2,2,3,null,null,3,4,null,null,4]

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(3);

        left1.left = left2;
        right1.right = right2;

        left2.left = new TreeNode(4);
        right2.left = new TreeNode(4);


        boolean balanced = isBalanced2(root);
        System.out.println(balanced);
    }

    public static boolean isBalanced1(TreeNode root){
        if(null == root){
            return true;
        }
        return Math.abs(height1(root.left) - height1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static int height1(TreeNode root){
        if(null == root){
            return 0;
        }
        return Math.max(height1(root.left),height1(root.right));
    }


    public static boolean isBalanced2(TreeNode root){
        if(null == root){
            return true;
        }
        return height2(root.left) != -1 && height2(root.right) != -1 &&  Math.abs(height2(root.left) - height2(root.right)) <= 1;
    }

    public static int height2(TreeNode root){
        if(null == root){
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }


}
