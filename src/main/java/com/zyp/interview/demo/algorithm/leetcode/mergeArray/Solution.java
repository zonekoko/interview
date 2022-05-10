package com.zyp.interview.demo.algorithm.leetcode.mergeArray;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n 。
 * @Author zhangyanping
 * @Date 2022/4/28 09:29
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 将nums2中的元素全部都放到nums1中，然后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }
        int index = 0;

        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] sorted = new int[nums1.length + nums2.length];
        while (index2 < nums2.length && index1 < m){
            sorted[index++] = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];
        }

        if(index1 >= m){
            System.arraycopy(nums2,index2,sorted,index,nums2.length - index2);
        }else {
            System.arraycopy(nums1,index1,sorted,index,nums1.length - index1);
        }


        System.arraycopy(sorted,0,nums1,0,nums1.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0){
            nums1[index--] = nums1[index1] <= nums2[index2] ? nums2[index2--] : nums1[index1--];
        }

        if(index1 < 0){
            System.arraycopy(nums2,0,nums1,0,index2 + 1);
        }
    }
}
