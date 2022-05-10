package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/2 08:26
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        selection(array);
    }

    private static void selection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(array, index, i);
                System.out.println("每次排序之后的结果：" + Arrays.toString(array));
            }
        }
        System.out.println("最终结果：" + Arrays.toString(array));

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
