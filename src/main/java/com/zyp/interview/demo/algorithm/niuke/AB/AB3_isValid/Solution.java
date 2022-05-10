package com.zyp.interview.demo.algorithm.niuke.AB.AB3_isValid;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 数据范围：字符串长度 0≤n≤10000
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 * @Author zhangyanping
 * @Date 2022/3/30 13:13
 * @Version 1.0
 */
public class Solution {

    public static boolean isValid(String s){
        if(s == null || "".trim().equals(s)){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[()]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
