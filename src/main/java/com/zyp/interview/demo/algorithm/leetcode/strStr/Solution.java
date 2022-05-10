package com.zyp.interview.demo.algorithm.leetcode.strStr;

/**
 * @ClassName Solution
 * @Description
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 *
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 * 
 * @Author zhangyanping
 * @Date 2022/4/13 10:58
 * @Version 1.0
 */
public class Solution {


    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    /**
     * 如果两个字符串有一个为空，则返回0；
     * 如果子串的长度大于母串的长度，返回-1；
     * 遍历两个字符串，记录母串从i位置往后的字符是不是和子串相对应，如果都相对应，子串遍历完成，那么返回i
     * 如果有一个不对应，那么母串向后移动，重新和母串进行匹配
     *
     */
    public static int strStr(String haystack,String needle){
        if(needle == null || "".equals(needle) || haystack == null || "".equals(haystack)){
            return 0;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        char[] hayStackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        int preI = -1;
        int preJ = -1;
        int index = -1;

        for (int i = 0; i < hayStackChars.length; i++) {
            if(preJ == needleChars.length - 1){
                return i - 1;
            }
            preI = i;
            index = i;
            for (int j = 0; j < needleChars.length; j++) {
                preJ = j;
                if(preI == hayStackChars.length ||hayStackChars[preI] != needleChars[j]){
                    preJ = -1;
                    break;
                }
                preI++;
            }
        }

        return preJ == needleChars.length - 1 ? index : -1;
    }
}
