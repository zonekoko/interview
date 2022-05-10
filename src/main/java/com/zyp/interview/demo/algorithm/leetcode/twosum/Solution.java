package com.zyp.interview.demo.algorithm.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * 给定一个整数数组 nums[]和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案
 *
 * @Author zhangyanping
 * @Date 2022/4/2 15:23
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
//        int[] result = twoSum1(nums, target);
        int[] result = twoSum2(nums, target);
        System.out.println(Arrays.toString(result));

    }

    /**
     * 双重for循环，时间复杂度O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums,int target){
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return result;
        }
        ok:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break ok;
                }
            }
        }
        return result;
    }

    /**
     * 用哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if(map.containsKey(j)){
                result[0] = i;
                result[1] = map.get(j);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
