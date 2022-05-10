package com.zyp.interview.demo.algorithm.niuke.AB.AB1_template_stack;

import java.util.Scanner;

/**
 * @ClassName TemplateStack
 * @Description 请你实现一个栈。
 * 操作：
 * push x：将 加x 入栈，保证 x 为 int 型整数。
 * pop：输出栈顶，并让栈顶出栈
 * top：输出栈顶，栈顶不出栈
 *
 * 输出描述：
 * 如果操作为push，则不输出任何东西。
 * 如果为另外两种，若栈为空，则输出 "error“
 * 否则按对应操作输出。
 * @Author zhangyanping
 * @Date 2022/3/29 17:25
 * @Version 1.0
 */
public class MyStack {
    private int[] data;
    private int maxSize;
    private int size = 0;
    private int top = 0;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    public void push(int x) {
        if (this.size == this.maxSize) {
            System.out.println("error");
        }
        data[top++] = x;
        size++;
    }

    public int pop() {
        if (this.size == 0) {
            System.out.println("error");
        }
        size--;
        top--;
        return data[top];
    }

    public int top() {
        if (this.size == 0) {
            System.out.println("error");
        }
        return data[top - 1];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(1024);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
