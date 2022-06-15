package com.zyp.interview.demo.algorithm.leetcode.addDigits;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//
//
//
// 示例 1:
//
//
//输入: num = 38
//输出: 2
//解释: 各位相加的过程为：
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//由于2 是一位数，所以返回 2。
//
//
// 示例 1:
//
//
//输入: num = 0
//输出: 0
//
//
//
// 提示：
//
//
// 0 <= num <= 2³¹ - 1
//
//
//
//
// 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
// Related Topics 数学 数论 模拟 👍 522 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/14 03:07
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int i = addDigits1(38);
        System.out.println(i);
    }
    public static int addDigits(int num) {
        if(num / 10 == 0){
            return num;
        }
        int sum = 0;
        while (num >= 10){
            sum+=num % 10;
            num = num / 10;
        }
        sum+=num;
      return addDigits(sum);
    }

    public static int addDigits1(int num){
        if(num < 10){
            return num;
        }
        while (true){
            int sum = 0;
            while (num >= 10){
                sum+=num % 10;
                num = num / 10;
            }
            sum+=num;
            if(sum < 10){
                return sum;
            }
            num = sum;
        }
    }
}
