package com.zyp.interview.demo.algorithm.leetcode.longestCommonPrefix;

/**
 * @ClassName Solution
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author zhangyanping
 * @Date 2022/4/6 14:14
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String prefix = longestCommonPrefix4(strs);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String temp = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++) {
            int count = Math.min(temp.length(), strs[i].length());
            int index = 0;
            while (index < count && temp.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            temp = temp.substring(0, index);
            if(temp.length() == 0){
                break;
            }
        }
        return temp;
    }

    public static String longestCommonPrefix2(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        String temp = strs[0];
        int count = temp.length();
        int length = strs.length;
        for (int i = 0; i < count; i++) {
            char c = temp.charAt(i);
            for (int j = 1; j < length; j++) {
                if( i == strs[j].length() || strs[j].charAt(i) != c ){
                    return temp.substring(0,i);
                }
            }
        }
        return temp;
    }

    public static String longestCommonPrefix3(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefixForLoop(strs,0,strs.length - 1);
    }

    private static String longestCommonPrefixForLoop(String[] strs, int start, int end) {
        if(start == end){
            return strs[start];
        }else{
            int middle = start + ((end - start) >> 1);
            String prefixLeft = longestCommonPrefixForLoop(strs, start, middle);
            String predixRight = longestCommonPrefixForLoop(strs, middle + 1, end);
            int count = Math.min(prefixLeft.length(), predixRight.length());
            int index = 0;
            while (index < count && prefixLeft.charAt(index)== predixRight.charAt(index)){
                index++;
            }
            return prefixLeft.substring(0,index);
        }
    }

    public static String longestCommonPrefix4(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength,str.length());
        }

        int low = 0;
        int high = minLength;
        while (low < high){
            int mid = low + ((high - low) >> 1) + 1;
            if(isCommonPrefix(strs,mid)){
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0,low);

    }

    private static boolean isCommonPrefix(String[] strs, int mid) {
        String prefix = strs[0].substring(0,mid);

        for (int i = 0; i < mid; i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != c){
                    return false;
                }
            }
        }
        return true;
    }


}
