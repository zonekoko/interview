package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName IsLands
 * @Description 岛问题
 * 【题目】
 * 一个矩阵中只有0和1两种值，
 * 每个位置都可以和自己的上、下、左、右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛?
 * 【举例】
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛
 * @Author zhangyanping
 * @Date 2022/2/22 13:41
 * @Version 1.0
 */
public class IsLands {

    public static void main(String[] args) {
        int[][] nums = {{0,0,1,0,1,1},{1,1,1,0,1,0},{1,0,0,1,0,0},{0,0,0,0,0,0}};
        System.out.println(countLands(nums));
    }

    public static int countLands(int[][] nums) {

        if (nums == null || nums[0] == null) {
            return 0;
        }

        int rows = nums.length;
        int cols = nums[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(nums[i][j] == 1){
                    res++;
                    infect(nums,i,j,rows,cols);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] nums, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || nums[i][j] != 1) {
            return;
        }
        nums[i][j] = 2;
        infect(nums, i - 1, j, rows, cols);
        infect(nums, i + 1, j, rows, cols);
        infect(nums, i, j - 1, rows, cols);
        infect(nums, i, j + 1, rows, cols);
    }


}
