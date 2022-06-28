package com.zyp.interview.demo.algorithm.leetcode.reverseString;
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//
//
// 示例 1：
//
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
//
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s[i] 都是 ASCII 码表中的可打印字符
//
// Related Topics 递归 双指针 字符串 👍 609 👎 0

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/28 16:13
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
