package com.zyp.interview.demo.algorithm.leetcode.containsDuplicate;
//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1]
//输出：true
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：false
//
// 示例 3：
//
//
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 数组 哈希表 排序

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/19 14:58
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length - 1){
            if(nums[index] == nums[++index]){
                return true;
            }
        }
        return false;
    }
}
