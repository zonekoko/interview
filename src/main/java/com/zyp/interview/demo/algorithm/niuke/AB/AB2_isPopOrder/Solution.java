package com.zyp.interview.demo.algorithm.niuke.AB.AB2_isPopOrder;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *  * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 *  * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *  * 1. 0<=pushV.length == popV.length <=1000
 *  * 2. -1000<=pushV[i]<=1000
 *  * 3. pushV 的所有数字均不相同
 * @Author zhangyanping
 * @Date 2022/3/30 11:09
 * @Version 1.0
 */
public class Solution {

    public static boolean isPopOrder(int[] pushA,int[] popA){
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushA.length){
            if(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }else {
                stack.push(pushA[pushIndex++]);
            }
        }
        while (!stack.isEmpty() && popIndex < popA.length){
           if(stack.pop() != popA[popIndex]){
               return false;
           }else{
               popIndex++;
           }
        }
        return true;
    }

    public static boolean IsPopOrder(int[] pushA,int[] popA){
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()){
                if(stack.peek() == popA[popIndex]){
                    stack.pop();
                    popIndex++;
                }else{
                    break;
                }
            }
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,1,2};
//        boolean popOrder = isPopOrder(pushA, popA);
        boolean popOrder = IsPopOrder(pushA, popA);
        System.out.println(popOrder);
    }


}
