package com.zyp.interview.demo.algorithm.leetcode.findPairs;
//给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
//
// k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
//
//
// 0 <= i, j < nums.length
// i != j
// nums[i] - nums[j] == k
//
//
// 注意，|val| 表示 val 的绝对值。
//
//
//
// 示例 1：
//
//
//输入：nums = [3, 1, 4, 1, 5], k = 2
//输出：2
//解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
//
//
// 示例 2：
//
//
//输入：nums = [1, 2, 3, 4, 5], k = 1
//输出：4
//解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
//
//
// 示例 3：
//
//
//输入：nums = [1, 3, 1, 5, 4], k = 0
//输出：1
//解释：数组中只有一个 0-diff 数对，(1, 1) 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁷ <= nums[i] <= 10⁷
// 0 <= k <= 10⁷
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 207 👎 0


import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/16 03:15
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 5, 4};
        int k = 0;
        int pairsCount = findPairs(nums, k);
        System.out.println(pairsCount);
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            ok:
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] == k){
                    count++;
                    break ok;
                }else if(nums[j] - nums[i] > k){
                    break ok;
                }
            }
            set.add(nums[i]);
        }
        return count;
    }
}
