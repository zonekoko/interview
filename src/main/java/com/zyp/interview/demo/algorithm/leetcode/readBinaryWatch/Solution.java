package com.zyp.interview.demo.algorithm.leetcode.readBinaryWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
//
//
//
// 例如，下面的二进制手表读取 "3:25" 。
//
//
//
//
// 给你一个整数 turnedOn ， 表示当前亮着的LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
//
// 小时不会以零开头：
//
//
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
//
//
// 分钟必须由两位数组成，可能会以零开头：
//
//
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
//
//
//
//
// 示例 1：
//
//
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
//
//
// 示例 2：
//
//
//输入：turnedOn = 9
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= turnedOn <= 10
//
// Related Topics 位运算 回溯 👍 366 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/7/4 15:09
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        int turnedOn = 1;
        List<String> strings = readBinaryWatch1(turnedOn);
        System.out.println(strings);

    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    res.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        return res;
    }

    public static List<String> readBinaryWatch1(int turnedOn){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6;
            int m = i & 63;
            if(h < 12 && m < 60 && Integer.bitCount(i) == turnedOn){
                res.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return res;
    }
}
