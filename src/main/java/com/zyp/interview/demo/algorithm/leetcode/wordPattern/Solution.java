package com.zyp.interview.demo.algorithm.leetcode.wordPattern;
//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
//
//
// 示例1:
//
//
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
//
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
//
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= pattern.length <= 300
// pattern 只包含小写英文字母
// 1 <= s.length <= 3000
// s 只包含小写英文字母和 ' '
// s 不包含 任何前导或尾随对空格
// s 中每个单词都被 单个空格 分隔
//
// Related Topics 哈希表 字符串 👍 472 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/15 02:24
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String pattern = "abcd";
        String s = "dog cat monkey fish";

        boolean b = wordPattern(pattern, s);
        System.out.println(b);

    }

    public static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] sArray = s.trim().split(" ");

        if(chars.length != sArray.length){
            return false;
        }
        int length = chars.length;
        Map<Character,String> characterStringHashMap = new HashMap<>();
        Map<String,Character> stringCharacterMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(!characterStringHashMap.containsKey(chars[i]) && !stringCharacterMap.containsKey(sArray[i])){
                characterStringHashMap.put(chars[i],sArray[i]);
                stringCharacterMap.put(sArray[i],chars[i]);
            }
            if(!sArray[i].equals(characterStringHashMap.get(chars[i])) || chars[i] != stringCharacterMap.get(sArray[i])){
                return false;
            }
        }
        return true;
    }
}
