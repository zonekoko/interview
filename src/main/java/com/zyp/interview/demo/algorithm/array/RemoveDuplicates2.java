package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName RemoveDuplocates2
 * @Description 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author zhangyanping
 * @Date 2022/2/18 10:23
 * @Version 1.0
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 2, 3, 3, 4};
        int i = removeDuplicates2(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates2(int[] nums){

        if(nums == null || nums.length == 0){
            return -1;
        }

        int i = 0;
        for (int num : nums) {
            if(i < 2 || nums[i-2] != num){
                nums[i++] = num;
            }

        }
        return i;
    }
}
