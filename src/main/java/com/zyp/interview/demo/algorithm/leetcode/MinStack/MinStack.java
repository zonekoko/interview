package com.zyp.interview.demo.algorithm.leetcode.MinStack;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 实现 MinStack 类:
//
//
// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。
// void pop() 删除堆栈顶部的元素。
// int top() 获取堆栈顶部的元素。
// int getMin() 获取堆栈中的最小元素。
//
//
//
//
// 示例 1:
//
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// -2³¹ <= val <= 2³¹ - 1
// pop、top 和 getMin 操作总是在 非空栈 上调用
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次
//
// Related Topics 栈 设计

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MinStack
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/12 13:38
 * @Version 1.0
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.getMin();

        System.out.println();
    }

    int size;

    Map<Integer,Integer> map = new ConcurrentHashMap<>();

    public MinStack() {
        this.size = 0;
    }

    public void push(int val) {
        map.put(size,val);
        size++;
    }

    public void pop() {
        map.remove(size);
        size--;
    }

    public int top() {
        if(size < 0){
            return 0;
        }
        Integer val = map.get(size - 1);
        return val;
    }

    public int getMin() {
        Integer min = map.get(size - 1);
        for (int i = size - 1; i >= 0; i--) {
            if(min > map.get(i)){
                min = map.get(i);
            }
        }
        return min;
    }
}
