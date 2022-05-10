package com.zyp.interview.demo.algorithm.niuke.AB.AB4_evalRPN;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 描述
 * 给定一个逆波兰表达式，求表达式的值。
 *
 * 数据范围：表达式长度满足 1≤n≤10^4
 *    ，表达式中仅包含数字和 + ，- , * , / ，其中数字的大小满足 ∣val∣≤200 。
 * @Author zhangyanping
 * @Date 2022/3/30 13:42
 * @Version 1.0
 */
public class Solution {

    public static int evalRPN(String[] tokens){
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");

        int c;
        c = Integer.parseInt(tokens[0]);
        for (String token : tokens) {

            if(list.contains(token)){
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    default:
                        c = b / a;
                        break;
                }
                stack.push(c);
            }else{
                stack.push(Integer.valueOf(token));
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","4","*"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }
}
