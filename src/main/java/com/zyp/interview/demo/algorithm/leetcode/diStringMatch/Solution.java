package com.zyp.interview.demo.algorithm.leetcode.diStringMatch;

//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
//
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//
//
// 示例 1：
//
//
//输入：s = "IDID"
//输出：[0,4,1,3,2]
//
//
// 示例 2：
//
//
//输入：s = "III"
//输出：[0,1,2,3]
//
//
// 示例 3：
//
//
//输入：s = "DDI"
//输出：[3,2,0,1]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含字符 "I" 或 "D"
//
// Related Topics 贪心 数组 数学 双指针 字符串

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/9 09:06
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "IDID";
        int[] result = diStringMatch(s);
        System.out.println(Arrays.toString(result));

    }

    public static int[] diStringMatch(String s) {
        if(null == s){
            return null;
        }
        char[] chars = s.toCharArray();
        int max = chars.length;
        int min = 0;

        int[] result = new int[max + 1];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'I'){
                result[i] = min;
                min++;
            }
            if(chars[i] == 'D'){
                result[i] = max;
                max--;
            }
        }
        result[chars.length] = min;
        return result;
    }

}
