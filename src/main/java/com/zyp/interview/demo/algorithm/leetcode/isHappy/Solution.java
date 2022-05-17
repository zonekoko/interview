package com.zyp.interview.demo.algorithm.leetcode.isHappy;
//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」 定义为：
//
//
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果这个过程 结果为 1，那么这个数就是快乐数。
//
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 哈希表 数学 双指针

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/17 11:29
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        boolean happy = isHappy(2);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            if(n == 1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            List<Integer> allNums = getAllNums(n);
            int temp = 0;
            for (Integer num : allNums) {
                temp= temp + (num * num);
            }
            n = temp;
        }
    }

    public static List<Integer> getAllNums(int n){
        List<Integer> list = new ArrayList<>();
        while (n>0){
            list.add(n % 10);
            n = n / 10;
        }
        return list;
    }
}
