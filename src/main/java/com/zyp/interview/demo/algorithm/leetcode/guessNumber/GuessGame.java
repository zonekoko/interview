package com.zyp.interview.demo.algorithm.leetcode.guessNumber;

/**
 * @ClassName GuessGame
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/29 14:42
 * @Version 1.0
 */
public class GuessGame {

    public static int guess(int num){
        int n = 1;
        if(num == n){
            return 0;
        }else if(n < num){
            return -1;
        }else {
            return 1;
        }
    }
}
