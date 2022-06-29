package com.zyp.interview.demo.algorithm.leetcode.intersect;
//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
// 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
// 可以不考虑输出结果的顺序。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 779 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/29 11:06
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect2(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect1(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int num1 : nums1) {
            Integer count = map.getOrDefault(num1, 0) + 1;
            map.put(num1,count);
        }

        int[] result = new int[nums1.length];
        int index = 0;
        for (int num2 : nums2) {
            if(map.containsKey(num2)){
                Integer value = map.get(num2);
                if(value > 0){
                    result[index++] = num2;
                    map.put(num2,value - 1);
                }
            }

        }
        return Arrays.copyOfRange(result,0,index);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[nums1.length];
        int n1 = nums1.length;
        int n2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while (index1 < n1 && index2 < n2){

            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if(num1 == num2){
                result[index++] = num1;
                index1++;
                index2++;
            }else if(num1 < num2){
                index1++;
            }else {
                index2++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
