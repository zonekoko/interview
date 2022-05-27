package com.zyp.interview.demo.algorithm.leetcode.findClosest;
//有个内含单词的超大文本文件，给定任意两个不同的单词，
// 找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗?
//
// 示例：
//
//
//输入：words = ["I","am","a","student","from","a","university","in","a","city"],
//word1 = "a", word2 = "student"
//输出：1
//
// 提示：
//
//
// words.length <= 100000
//
// Related Topics 数组 字符串 👍 54 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/27 10:26
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String[] words = {"a","z","b","g","a"};
        String word1 = "a";
        String word2 = "g";

        int closest = findClosest(words, word1, word2);
        System.out.println(closest);

    }

    public static int findClosest(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int former = -1;
        String temp = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word1.equals(word) || word2.equals(word)){
                if(!"".equals(temp) && !word.equals(temp)){
                    minDistance = Math.min(minDistance,i - former);
                }
                temp = word;
                former = i;
            }

        }
        return minDistance;
    }

    public static int findClosest1(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }

}
