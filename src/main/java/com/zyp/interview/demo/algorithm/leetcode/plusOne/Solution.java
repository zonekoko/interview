package com.zyp.interview.demo.algorithm.leetcode.plusOne;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @Author zhangyanping
 * @Date 2022/4/18 10:33
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] plusOne(int[] digits){
        if(digits == null || digits.length == 0){
            return new int[]{0};
        }
        int index = digits.length - 1;
        while (index >= 0){
            if(digits[index] == 9){
                digits[index] = 0;
                index--;
            }else{
                digits[index] = digits[index] + 1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits,0,result,1,digits.length);
        result[0] = 1;
        return result;
    }

}
