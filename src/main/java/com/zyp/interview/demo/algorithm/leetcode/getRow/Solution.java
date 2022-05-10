package com.zyp.interview.demo.algorithm.leetcode.getRow;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author zhangyanping
 * @Date 2022/5/6 14:35
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> result = getRow1(3);
        System.out.println(result);
    }

    public static List<Integer> getRow1(int rowIndex){
        List<List<Integer>> triangleList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> rowList = new ArrayList<>();
            if(i == 0){
                rowList.add(1);
                triangleList.add(rowList);
                continue;
            }
            List<Integer> formerList = triangleList.get(i - 1);
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
                rowList.add(left + right);
            }
            triangleList.add(rowList);
        }
        return triangleList.get(rowIndex);
    }


}
