package com.zyp.interview.demo.algorithm.leetcode.isPalindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * @Author zhangyanping
 * @Date 2022/4/2 17:01
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
//        boolean palindrome = isPalindrome1(123);
//        boolean palindrome = isPalindrome2(123);
        boolean palindrome = isPalindrome3(1212);
        System.out.println(palindrome);
    }

    /**
     * 思路：
     * 利用栈先进后出的特性，将x转成字符串，遍历字符数组，将字符压进栈中。
     * 然后再遍历，边弹出栈顶元素边比较，如果有一个不一样，则不是回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        //将每个字符压入栈中
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        //遍历字符数组，边遍历，边弹出栈顶元素比较，如果不一样，则不是回文数
        for (int i = 0; i < chars.length; i++) {
            if (stack.pop() != chars[i]) {
                return false;
            }
        }
        //判断栈中元素是否为空，为空则代表全部相等
        return stack.isEmpty();
    }

    /**
     * 思路：
     * 栈：先进后出
     * 队列：先进先出
     * x对10取余，获得个位数分别压进栈和队列中，
     * 然后x = x/10。把x变成个位数之前的数组
     * 遍历栈和队列，判断弹出的元素是否相等
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        //将每一位数压进栈和队列中
        while (x != 0) {
            stack.push(x % 10);
            queue.add(x % 10);
            x = x / 10;
        }
        //遍历栈和队列，判断元素是否相等
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return queue.isEmpty();
    }

    /**
     * 思路：
     * 负数不可能为回文数
     * 10的倍数的数不可能为回文数
     * 0是回文数
     *
     * 将x 后一半的数字反转，x = x 前一半的值
     * 如果是偶数，那反转过后的值等于x，
     * 如果是奇数，那反转过后的值 / 10 等于x
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        //负数不可能为回文数
        if (x < 0) {
            return false;
        }
        //10的倍数不可能为回文数
        if (x >= 10 && x % 10 == 0) {
            return false;
        }
        //0是天然的回文数
        if(x == 0){
            return true;
        }

        //定义反转之后的数
        int reverseNumber = 0;
        // reverseNumber = reverseNumber * 10 + 最后一位数
        // x = x / 10
        //当reverseNumber>=x时，说明已经反转了一半
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + (x % 10);
            x = x / 10;
        }

        //当reverseNumber = x(偶数个数)或者 x==reverseNumber / 10(奇数个数)时是回文数
        if(x == reverseNumber / 10 || x == reverseNumber){
            return true;
        }
        return false;
    }
}
