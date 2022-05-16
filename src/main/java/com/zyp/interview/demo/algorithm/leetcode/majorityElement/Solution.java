package com.zyp.interview.demo.algorithm.leetcode.majorityElement;
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
//
//
//
//提示：
//
//
// n == nums.length
// 1 <= n <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
// Related Topics 数组 哈希表 分治 计数 排序
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/13 17:37
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {6,6,6,7,7};
        int i = majorityElement(nums);
        System.out.println(i);

    }

    public static int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int num : nums) {
            if(result != num){
                if(--count <= 0){
                    result = num;
                    count = 1;
                }
            }else {
                count++;
            }
        }
        return result;
    }
}
