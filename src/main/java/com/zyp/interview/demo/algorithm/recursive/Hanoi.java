package com.zyp.interview.demo.algorithm.recursive;

/**
 * @ClassName Hanoi
 * @Description 汉诺塔问题
 * 打印n层汉诺塔从最左边移动到最右边的全部过程
 * @Author zhangyanping
 * @Date 2022/2/21 14:00
 * @Version 1.0
 */
public class Hanoi {

    public static void main(String[] args) {

        hanoi(2);
    }

    public static void hanoi(int n){
        if(n > 0){
            func(n,n,"left","mid","right");
        }
    }

    public static void func(int reset, int down, String from, String help, String to) {
        if (reset == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(reset - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(reset - 1, down - 1, help, from, to);
        }
    }


}
