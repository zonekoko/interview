package com.zyp.interview.demo.algorithm.recursive;

import java.util.Stack;

/**
 * @ClassName ReverseStack
 * @Description
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。
 * 如何实现?
 * @Author zhangyanping
 * @Date 2022/2/21 15:42
 * @Version 1.0
 */
public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
    }

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


}
