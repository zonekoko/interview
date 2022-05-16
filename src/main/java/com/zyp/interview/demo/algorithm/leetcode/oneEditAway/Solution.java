package com.zyp.interview.demo.algorithm.leetcode.oneEditAway;
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
// 示例 1:
//
// 输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//
// 示例 2:
//
// 输入:
//first = "pales"
//second = "pal"
//输出: False
//
// Related Topics 双指针 字符串
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/13 09:21
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String first = "mart";
        String second = "karma";
        boolean b = oneEditAway(first, second);
        System.out.println(b);
    }

    public static boolean oneEditAway(String first, String second) {
        if(first == null || second == null){
            return false;
        }
        if(Math.abs(first.length() - second.length()) > 1){
            return false;
        }
        if(first.length() == second.length()){
            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            int unSameCount = 0;
            int index = 0;
            while (index < firstChars.length){
                if(firstChars[index] != secondChars[index]){
                    unSameCount++;
                }
                index++;
            }
            if(unSameCount > 1){
                return false;
            }
            return true;
        }
        String longStr = first.length() > second.length() ? first : second;
        String lowStr = first.length() > second.length() ? second : first;
        int i = 0;
        int j = 0;
        int unSameCount = 0;
        char[] longChars = longStr.toCharArray();
        char[] lowChars = lowStr.toCharArray();
        while (j < lowChars.length){
            if(unSameCount > 1){
                return false;
            }
            if(longChars[i] == lowChars[j]){
                i++;
                j++;
            }else{
                i++;
                unSameCount++;
            }
        }
        return true;
    }
}
