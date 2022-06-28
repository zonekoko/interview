package com.zyp.interview.demo.algorithm.leetcode.reverseVowels;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由 可打印的 ASCII 字符组成
//
// Related Topics 双指针 字符串 👍 253 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/28 16:18
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "hello";
        String s1 = reverseVowels1(s);
        System.out.println(s1);
    }

    public static String reverseVowels1(String s) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('e');
        set.add('u');
        set.add('o');
        set.add('A');
        set.add('I');
        set.add('E');
        set.add('U');
        set.add('O');

        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            if((set.contains(chars[left]) && (set.contains(chars[right])))){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }else if(!(set.contains(chars[left])) && !(set.contains(chars[right]))){
                left++;
                right--;
            }else {
                if(set.contains(chars[left])){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return new String(chars);
    }
}
