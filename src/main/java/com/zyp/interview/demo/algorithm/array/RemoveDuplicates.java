package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName RemoveDuplicates
 * @Description 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 思路：
 * 1.遍历数组
 * 2.变量i表示下一个不同的数要修改的位置
 * 3.i=0时，就将0位置改为数组的0位置，
 * 4.i > 0时，看数组的当前元素和i位置的前一个是否相同，相同就跳过，不相同就将i位置改为当前元素，i++
 * 5.知道遍历完数组，返回i就是所需要的长度，数组中超过这个长度的不考虑
 * @Author zhangyanping
 * @Date 2022/2/18 09:43
 * @Version 1.0
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        //[1,1,2]
        //[0,0,1,1,1,2,2,3,3,4]
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //i表示下一个不同的数要修改的位置
        int i = 0;
        for (int num : nums) {
            if (i < 1 || num != nums[i - 1]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
