package com.zyp.interview.demo.algorithm.leetcode.containsNearbyDuplicate;
//给你一个整数数组 nums 和一个整数 k ，
// 判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i- j) <= k 。
// 如果存在，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1], k = 3
//输出：true
//
// 示例 2：
//
//
//输入：nums = [1,0,1,1], k = 1
//输出：true
//
// 示例 3：
//
//
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
//
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// 0 <= k <= 10⁵
//
// Related Topics 数组 哈希表 滑动窗口

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/19 15:18
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num) && Math.abs(map.get(num) - i) <= k){
                return true;
            }
            map.put(num,i);
        }
        return false;
    }
}
