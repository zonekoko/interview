package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/8 09:58
 */
public class ShellSort {

    public static void main(String[] args) {
                int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(array);
    }

    private static void shellSort(int[] array) {
        for (int d = array.length / 2; d > 0; d /= 2) {//设置增量
            for (int i = d; i < array.length; i++) {//设置数组下标
                int j = i - d;
                int temp = array[i];
                while (j >= 0) {
                    if (array[j] > temp) {
                        array[j + d] = array[j];
                        j = j - d;
                        System.out.println("排序结果：" + Arrays.toString(array));
                    } else {
                        break;
                    }

                }
                array[j + d] = temp;
            }
        }
        System.out.println("最终结果：" + Arrays.toString(array));
    }
}
