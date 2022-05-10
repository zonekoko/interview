package com.zyp.interview.demo.algorithm.leetcode.removeDuplicates;

/**
 * @ClassName Solution
 * @Description 给你一个升序排列 的数组 nums ，
 * 请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author zhangyanping
 * @Date 2022/4/12 09:59
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates2(nums);
        System.out.println(i);

    }

    public static int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums == null ? 0 : nums.length;
        }
        int slow = 1;
        int fast = 1;
        while (fast <= nums.length - 1){
            if(nums[fast] == nums[slow - 1]){
                fast++;
            }else{
                if(fast != slow){
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }
                fast++;
                slow++;
            }
        }
        return slow;
    }

    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums == null ? 0 : nums.length;
        }
        int slow = 1;
        int fast = 1;
        while (fast <= nums.length - 1){
            if(nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
