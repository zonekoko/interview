package com.zyp.interview.demo.algorithm.leetcode.searchInsert;

/**
 * @ClassName Solution
 * @Description
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @Author zhangyanping
 * @Date 2022/4/14 09:24
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums= {1,3,5,6};
        int target = 2;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums,int target){
        if (nums == null || nums.length ==0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (right - left) >> 1 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left] >= target ? left : left + 1;
    }
}
