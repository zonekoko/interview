package com.zyp.interview.demo.algorithm.leetcode.removeElement;

/**
 * @ClassName Solution
 * @Description 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author zhangyanping
 * @Date 2022/4/13 09:33
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int val = 1;
        int i = removeElement1(nums, val);
        System.out.println(i);
    }


    /**
     * 由于题目要求删除数组中等于val的元素，因此输出数组的长度一定小于等于输入数组的长度，
     * 我们可以把输出的数组直接写在输入数组上。
     * 可以使用双指针：右指针right指向当前将要处理的元素，左指针left指向下一个将要赋值的位置。
     *
     * 如果右指针指向的元素不等于val，它一定是输出数组的一个元素，
     * 我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
     *
     * 如果右指针指向的元素等于val，它不能在输出数组里，此时左指针不动，右指针右移一位。
     *
     * 整个过程保持不变的性质是：区间[0,left)中的元素都不等于val。
     * 当左右指针遍历完输入数组以后，left 的值就是输出数组的长度。
     *
     * 这样的算法在最坏情况下（输入数组中没有元素等于val），左右指针各遍历了数组一次。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums,int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int fast = 0;
        int low = 0;
        while (fast < nums.length){
            if(nums[fast] != val){
                if(fast != low){
                    nums[low] = nums[fast];
                }
                low++;
            }
            fast++;
        }
        return low;
    }

    /**
     * 如果左指针 left 指向的元素等于 val，此时将右指针 right 指向的元素复制到左指针 left 的位置，
     * 然后右指针 right 左移一位。
     * 如果赋值过来的元素恰好也等于 val，可以继续把右指针right指向的元素的值赋值过来（左指针 left 指向的等于 val 的元素的位置继续被覆盖），
     * 直到左指针指向的元素的值不等于val为止。
     *
     * 当左指针left和右指针right重合的时候，左右指针遍历完数组中所有的元素。
     *
     * 这样的方法两个指针在最坏的情况下合起来只遍历了数组一次。与方法一不同的是，方法二避免了需要保留的元素的重复赋值操作。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}
