package com.zyp.interview.demo.algorithm.leetcode.isSubsequence;
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。
//
// 进阶：
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？
//
//
//
// 示例 1：
//
//
//输入：s = "abc", t = "ahbgdc"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "axc", t = "ahbgdc"
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// 两个字符串都只由小写字符组成。
//
// Related Topics 双指针 字符串 动态规划 👍 676 👎 0


/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/30 14:34
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int index1 = 0;
        int index2 = 0;

        while (index1 < sChars.length && index2 < tChars.length){
            if(sChars[index1] == tChars[index2]){
                index1++;
                index2++;
            }else {
                index2++;
            }
        }
        return index1 >= sChars.length;
    }
}
