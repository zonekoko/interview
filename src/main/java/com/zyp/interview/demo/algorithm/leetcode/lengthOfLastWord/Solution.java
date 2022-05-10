package com.zyp.interview.demo.algorithm.leetcode.lengthOfLastWord;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * @Author zhangyanping
 * @Date 2022/4/18 10:12
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String str = "Hello World";
        int i = lengthOfLastWord(str);
        System.out.println(i);

    }

    public static int lengthOfLastWord1(String s){
        s = s.trim();
        if(s == null){
            return 0;
        }
        String[] strArray = s.split(" ");
        return strArray[strArray.length - 1].length();
    }

    public static int lengthOfLastWord(String s){
        if(s == null){
            return 0;
        }
        int index = s.length() - 1;
        while (s.charAt(index) == ' '){
            index--;
        }
        int wordIndex = 0;
        while (index >= 0 && s.charAt(index) != ' '){
            wordIndex++;
            index--;
        }
        return wordIndex;
    }


}
