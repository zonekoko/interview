package com.zyp.interview.demo.algorithm.leetcode.isPalindrome_1;

////给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
////
//// 说明：本题中，我们将空字符串定义为有效的回文串。
////
////
////
//// 示例 1:
////
////
////输入: "A man, a plan, a canal: Panama"
////输出: true
////解释："amanaplanacanalpanama" 是回文串
////
////
//// 示例 2:
////
////
////输入: "race a car"
////输出: false
////解释："raceacar" 不是回文串
////
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 2 * 10⁵
//// 字符串 s 由 ASCII 字符组成
////
//// Related Topics 双指针 字符串
//

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/9 15:33
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome2(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome1(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                sb.append(chars[i]);
            }
        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }

    public static boolean isPalindrome2(String s){
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(chars[left])){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])){
                right--;
            }
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
