package com.zyp.interview.demo.algorithm.leetcode.isPerfectSquare;
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。
//
//
//
// 示例 1：
//
//
//输入：num = 16
//输出：true
//
//
// 示例 2：
//
//
//输入：num = 14
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics 数学 二分查找 👍 406 👎 0

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/29 14:10
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int num = 16;
        boolean perfectSquare = isPerfectSquare(num);
        System.out.println(perfectSquare);
    }

    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long squre = (long)mid * mid;
            if (squre == num) {
                return true;
            } else if (squre < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
