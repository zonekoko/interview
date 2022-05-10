package com.zyp.interview.demo.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *你可以按任意顺序返回答案。只会存在一个有效答案
 *
 *遍历数组的同时用哈希表存放数组的值以及对应的下标
 * 如果val-nums[i] 在哈希表中有值，说明找到了目标值
 * @Author zhangyanping
 * @Date 2022/2/21 11:16
 * @Version 1.0
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,2,11,15};
        int[] ints = twoSum2(nums, 13);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] twoSum1(int[] nums ,int val){
        int[] res = new int[2];
        ok:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == val){
                    res[0] = i;
                    res[1] = j;
                    break ok;
                }
            }
        }
        return res;
    }

    public static int[] twoSum2(int[] nums,int val){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = val - nums[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
