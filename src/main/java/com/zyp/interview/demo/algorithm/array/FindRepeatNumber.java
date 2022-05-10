package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName FindRepeatNumber
 * @Description 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 三种方式：
 *
 * - 排序
 * 1。先排序，将相同的数字聚集到一起
 * 2。再遍历，当位于i位置和i+1位置的数相等时，返回该数
 *
 * - 哈希表
 * 记录数字再数组中的数量，当数量为2时，返回即可
 *
 * - 原地交换
 * 1。0～n-1范围内的数，分别还原到对应的位置上，如：数字2交换到下标为2的位置
 * 2。若交换过程中发现重复，则直接返回
 *
 * @Author zhangyanping
 * @Date 2022/2/18 13:23
 * @Version 1.0
 */
public class FindRepeatNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,1,3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
