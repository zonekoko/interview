package com.zyp.interview.demo.algorithm.leetcode.isAlienSorted;
//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
// 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回false。
//
//
//
// 示例 1：
//
//
//输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
//
// 示例 2：
//
//
//输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
//
// 示例 3：
//
//
//输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，
// 因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// 在 words[i] 和 order 中的所有字符都是英文小写字母。
//
// Related Topics 数组 哈希表 字符串

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/17 10:14
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        //["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"]
        //"zkgwaverfimqxbnctdplsjyohu"
        String[] words = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        String order = "zkgwaverfimqxbnctdplsjyohu";
        boolean alienSorted = isAlienSorted(words, order);
        System.out.println(alienSorted);

    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        map.put('∅',index);
        char[] chars = order.toCharArray();
        for (char c : chars) {
            map.put(c,++index);
        }
        for (int i = 0; i < words.length; i++) {
            if(i + 1 == words.length){
                return true;
            }
            String word = words[i];
            String nextWord = words[i + 1];
            char[] wordChars = word.toCharArray();
            char[] nextWordChars = nextWord.toCharArray();
            int maxLength = Math.max(word.length(), nextWord.length());
            OK:
            for (int j = 0; j < maxLength; j++) {
                char wordChar = '∅';
                char nextWordChar = '∅';
                if(j < wordChars.length){
                    wordChar = wordChars[j];
                }
                if(j < nextWordChars.length){
                    nextWordChar = nextWordChars[j];
                }

                if(map.get(wordChar) > map.get(nextWordChar)){
                    return false;
                }else if(map.get(wordChar) == map.get(nextWordChar)){
                    continue ;
                }else{
                    break OK;
                }
            }
        }
        return true;
    }
}
