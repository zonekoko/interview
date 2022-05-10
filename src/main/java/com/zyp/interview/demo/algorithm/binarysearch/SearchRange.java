package com.zyp.interview.demo.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName SearchRange
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @Author zhangyanping
 * @Date 2022/1/25 13:04
 * @Version 1.0
 */
public class SearchRange {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] searchRange(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        //find first position
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else{
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int l = left;

        right = nums.length - 1;
        //find last position
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{l, left};
    }
}
