package com.zyp.interview.demo.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralOrder
 * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 解法：
 * 从外往里一圈一圈遍历并存储矩阵元素即可。
 * @Author zhangyanping
 * @Date 2022/2/18 16:32
 * @Version 1.0
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> integers = spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        //行数
        int m = matrix.length;
        //列数
        int n = matrix[0].length;
        int i1 = 0;
        int i2 = m - 1;
        int j1 = 0;
        int j2 = n - 1;
        while (i1 <= i2 && j1 <= j2){
            add(matrix,i1++,j1++,i2--,j2--,res);
        }
        return res;
    }

    public static void add(int[][] matrix,int i1,int j1,int i2,int j2,List<Integer> res){
        if (i1 == i2) {
            for (int j = j1; j <= j2; ++j) {
                res.add(matrix[i1][j]);
            }
            return;
        }
        if (j1 == j2) {
            for (int i = i1; i <= i2; ++i) {
                res.add(matrix[i][j1]);
            }
            return;
        }
        for (int j = j1; j < j2; ++j) {
            res.add(matrix[i1][j]);
        }
        for (int i = i1; i < i2; ++i) {
            res.add(matrix[i][j2]);
        }
        for (int j = j2; j > j1; --j) {
            res.add(matrix[i2][j]);
        }
        for (int i = i2; i > i1; --i) {
            res.add(matrix[i][j1]);
        }
    }
}
