package com.zyp.interview.demo.algorithm.leetcode.isValid;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author zhangyanping
 * @Date 2022/4/7 15:19
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c == '{'){
                stack.push('}');
            }else if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty() || stack.peek() != c){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
