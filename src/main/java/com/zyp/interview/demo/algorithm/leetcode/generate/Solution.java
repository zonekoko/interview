package com.zyp.interview.demo.algorithm.leetcode.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author zhangyanping
 * @Date 2022/5/6 10:37
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> numList = new ArrayList<>();
            if(i == 0){
                numList.add(1);
                result.add(numList);
                continue;
            }
            List<Integer> formerList = result.get(i - 1);
            for (int j = 0; j <= i; j++) {
                int left;
                int right;
                if(j == 0){
                    left = 0;
                }else {
                    left = formerList.get(j - 1);
                }
                if(j == i){
                    right = 0;
                }else {
                    right = formerList.get(j);
                }
                numList.add(left + right);
            }
            result.add(numList);
        }
        return result;
    }
}
