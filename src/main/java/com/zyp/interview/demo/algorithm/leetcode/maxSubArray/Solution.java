package com.zyp.interview.demo.algorithm.leetcode.maxSubArray;

/**
 * @ClassName Solution
 * @Description
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @Author zhangyanping
 * @Date 2022/4/14 09:39
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-1};
        int[] nums = {-1,-2};
//        int[] nums = {5,4,-1,7,8};
//        int[] nums = {1,2};
//        int[] nums = {8,-19,5,-4,20};
//        int[] nums = {-1,0,-2};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            count += num;
            if(max < count){
                max = count;
            }
            if(count < num){
                count = num;
                max = max > num ? max : num;
            }
        }
        return max;
    }
}
