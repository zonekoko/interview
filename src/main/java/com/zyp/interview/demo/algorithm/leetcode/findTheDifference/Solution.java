package com.zyp.interview.demo.algorithm.leetcode.findTheDifference;
//给定两个字符串 s 和 t ，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
//
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
//
//输入：s = "", t = "y"
//输出："y"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表 字符串 排序 👍 328 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/30 13:59
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String s = "";
        String t = "y";
        char theDifference = findTheDifference(s, t);
        System.out.println(theDifference);


    }

    public static char findTheDifference(String s, String t) {
        int index = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int aChar1 = aChar;
            index = index ^ aChar1;
        }
        for (char c : t.toCharArray()) {
            int c1 = c;
            index = index ^ c1;
        }
        return (char) index;
    }
}
