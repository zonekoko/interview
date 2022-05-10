package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName RemoveElement
 * @Description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author zhangyanping
 * @Date 2022/2/18 10:56
 * @Version 1.0
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int i = removeElement2(nums,3);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeElement(int[] nums,int val){
        int i = 0;
        for (int num : nums) {
            if(num != val){
                nums[i++] = num;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums,int val){
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) ++cnt;
            else nums[i - cnt] = nums[i];
        }
        return n - cnt;
    }




}
