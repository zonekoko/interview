package com.zyp.interview.demo.algorithm.leetcode.intersection;
//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 564 👎 0

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/28 16:36
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] intersection = intersection1(nums1, nums2);
        System.out.println(Arrays.toString(intersection));

    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> set3 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (Integer integer : set1) {
            if(set2.contains(integer)){
                set3.add(integer);
            }
        }
        int[] result = new int[set3.size()];
        Iterator<Integer> iterator = set3.iterator();
        int count = 0;
        while (iterator.hasNext()){
            result[count++] = iterator.next();
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] temp = new int[length1 + length2];

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < length1 && index2 < length2){
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if(num1 == num2){
                if(index == 0 || num1 != temp[index - 1]){
                    temp[index++] = num1;
                }
                index1++;
                index2++;
            }else if(num1 < num2){
                index1++;
            }else {
                index2++;
            }
        }
        return Arrays.copyOfRange(temp,0,index);
    }
}
