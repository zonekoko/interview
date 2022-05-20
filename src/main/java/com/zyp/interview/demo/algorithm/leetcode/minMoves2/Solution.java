package com.zyp.interview.demo.algorithm.leetcode.minMoves2;
//给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
//
// 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：2
//解释：
//只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [1,10,2,9]
//输出：16
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 数组 数学 排序

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/19 13:50
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        int result = minMoves2(nums);
        System.out.println(result);
    }

    public static int minMoves2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        if(nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) >> 1 + left;
        int num = nums[mid];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result+=Math.abs(nums[i] - num);
        }
        return result;
    }
}
