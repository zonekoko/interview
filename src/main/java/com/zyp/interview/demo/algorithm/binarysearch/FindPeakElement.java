package com.zyp.interview.demo.algorithm.binarysearch;

import java.util.Objects;

/**
 * @ClassName FindPeakElement
 * @Description 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * @Author zhangyanping
 * @Date 2022/1/26 14:10
 * @Version 1.0
 */
public class FindPeakElement {
    public static void main(String[] args) {

        int[] nums = {1, 5, 3, 3, 5, 6};
        int index = findPeakElement(nums);
        System.out.println(index);
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
