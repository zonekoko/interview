package com.zyp.interview.demo.algorithm.leetcode.isPowerOfTwo;
//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：true
//解释：2⁰ = 1
//
//
// 示例 2：
//
//
//输入：n = 16
//输出：true
//解释：2⁴ = 16
//
//
// 示例 3：
//
//
//输入：n = 3
//输出：false
//
//
// 示例 4：
//
//
//输入：n = 4
//输出：true
//
//
// 示例 5：
//
//
//输入：n = 5
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
// Related Topics 位运算 递归 数学
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/21 17:09
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        int n = 0;
        boolean powerOfTwo1 = isPowerOfTwo(n);
        System.out.println(powerOfTwo1);

    }

    public static boolean isPowerOfTwo1(int n) {
        if(n < 1){
            return false;
        }
        while (n > 1){
            if(n % 2 == 0){
                n = n / 2;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPowerOfTwo(int n){
        if(n < 1){
            return false;
        }
        int i = n & (n - 1);
        return  i == 0;
    }
}
