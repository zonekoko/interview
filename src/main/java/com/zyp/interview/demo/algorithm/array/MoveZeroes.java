package com.zyp.interview.demo.algorithm.array;

import java.util.Arrays;

/**
 * @ClassName MoveZeroes
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明：
 * 1.必须在原数组上操作，不能拷贝额外的数组
 * 2.尽量减少操作次数
 * @Author zhangyanping
 * @Date 2022/2/18 11:28
 * @Version 1.0
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums){
        int zeroCount = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] == 0){
                zeroCount++;
            }else {
                nums[i - zeroCount] = nums[i];
            }
        }
        for (int i = length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums){
        int left = 0, n = nums.length;
        for (int right = 0; right < n; ++right) {
            if (nums[right] != 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                ++left;
            }
        }
    }
}
