package com.zyp.interview.demo.algorithm.binarysearch;

/**
 * @ClassName Sqrt
 * @Description 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @Author zhangyanping
 * @Date 2022/1/26 09:27
 * @Version 1.0
 */
public class Sqrt {

    public static void main(String[] args) {
        int sqrt = sqrt(8);
        System.out.println(sqrt);
    }

    public static int sqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
