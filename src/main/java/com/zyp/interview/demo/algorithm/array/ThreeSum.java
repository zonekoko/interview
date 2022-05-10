package com.zyp.interview.demo.algorithm.array;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName threeSum
 * @Description
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @Author zhangyanping
 * @Date 2022/2/21 11:38
 * @Version 1.0
 */
public class ThreeSum {

    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum1(int[] nums){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }

        //存放的是数值对应的个数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            for (Integer integer : map.keySet()) {

            }

        }
        return null;
    }
}
