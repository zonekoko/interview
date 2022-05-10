package com.zyp.interview.demo.algorithm.leetcode.sortedArrayToBST;

/**
 * @ClassName Solution
 * @Description
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
 *
 * @Author zhangyanping
 * @Date 2022/5/4 10:35
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);

    }

    public static TreeNode sortedArrayToBST(int[] nums){

        return helper(nums,0, nums.length - 1);

    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = ((right - left) >> 1) + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid - 1);
        root.right = helper(nums,mid + 1,right);
        return root;
    }

}
