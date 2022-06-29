package com.zyp.interview.demo.algorithm.leetcode.canConstruct;
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 363 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/29 16:13
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> map = new HashMap<>();

        char[] magazineChars = magazine.toCharArray();
        for (char magazineChar : magazineChars) {
            int count = map.getOrDefault(magazineChar, 0) + 1;
            map.put(magazineChar,count);
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteChars) {
            if(!map.containsKey(ransomNoteChar) || map.get(ransomNoteChar) <= 0){
                return false;
            }
            int i = map.get(ransomNoteChar) - 1;
            map.put(ransomNoteChar,i);
        }
        return true;
    }
}
