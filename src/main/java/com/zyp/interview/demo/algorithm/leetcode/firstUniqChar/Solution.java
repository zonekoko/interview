package com.zyp.interview.demo.algorithm.leetcode.firstUniqChar;
//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入: s = "leetcode"
//输出: 0
//
//
// 示例 2:
//
//
//输入: s = "loveleetcode"
//输出: 2
//
//
// 示例 3:
//
//
//输入: s = "aabb"
//输出: -1
//
//
//
//
// 提示:
//
//
// 1 <= s.length <= 10⁵
// s 只包含小写字母
//
// Related Topics 队列 哈希表 字符串 计数 👍 562 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/30 13:38
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "aabb";
        int index = firstUniqChar(s);
        System.out.println(index);
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : chars) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c,count);
            queue.offer(c);
        }

        int index = 0;

        while (!queue.isEmpty()){
            Character cur = queue.poll();
            if(map.get(cur) == 1){
                return index;
            }
            index++;
        }
        return -1;
    }
}
