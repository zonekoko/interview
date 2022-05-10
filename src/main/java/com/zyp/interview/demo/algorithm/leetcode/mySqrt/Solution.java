package com.zyp.interview.demo.algorithm.leetcode.mySqrt;

/**
 * @ClassName Solution
 * @Description 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @Author zhangyanping
 * @Date 2022/4/20 13:46
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        int i = mySqrt1(1);
        System.out.println(i);

    }

    public static int mySqrt1(int x){
        if(x == 0){
            return 0;
        }
        int res = (int) Math.exp(0.5 * Math.log(x));
        return (long) (res + 1) * (res + 1) <= x ? res + 1 : res;
    }
}
