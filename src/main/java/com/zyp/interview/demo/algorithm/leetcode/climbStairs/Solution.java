package com.zyp.interview.demo.algorithm.leetcode.climbStairs;

/**
 * @ClassName Solution
 * @Description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Author zhangyanping
 * @Date 2022/4/27 13:53
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int i = climbStairs(10);
        System.out.println(i);
    }

    /**
     * 思路：
     * 用f(x)来表示走到第x层的方案数，最后一步可能走了一步，也可能走了两步，所以
     * f(x) = f(x - 1) + f(x - 2)
     * 这个公式意味着，走到第x层的方案数是 走到第x-1的方案数 和 走到第x-2层的方案数之和
     * 因为每次只能爬一阶或两阶，所以f(x)只能从f(x-1)和f(x-2)转移过来
     * @param n
     * @return
     */
    public static int climbStairs1(int n){
        if(n <= 2){
            return n;
        }
        int res = 0;
        res+=climbStairs1(n - 1);
        res+=climbStairs1(n - 2);
        return res;
    }

    /**
       * 思路：
       * 用f(x)来表示走到第x层的方案数，最后一步可能走了一步，也可能走了两步，所以
       * f(x) = f(x - 1) + f(x - 2)
       * 这个公式意味着，走到第x层的方案数是 走到第x-1的方案数 和 走到第x-2层的方案数之和
       * 因为每次只能爬一阶或两阶，所以f(x)只能从f(x-1)和f(x-2)转移过来
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
