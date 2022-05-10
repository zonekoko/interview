package com.zyp.interview.demo.algorithm.leetcode.singleNumber;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 数组


import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date  2022/5/10 09:50
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4,1,4,1,2};
        int i = singleNumber(nums);
        System.out.println(i);
    }


    /**
     * 思路，先排序，再遍历
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        //排序
        Arrays.sort(nums);
        int low = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[low] != nums[fast]){
                if(fast - low == 1){
                    return nums[low];
                }
                low = fast;
            }
            fast++;
        }
        return nums[low];
    }

    public static int singleNumber(int[] nums){
        int singleNumber = 0;
        for (int num : nums){
            singleNumber = singleNumber ^ num;
        }
        return singleNumber;
    }

}
