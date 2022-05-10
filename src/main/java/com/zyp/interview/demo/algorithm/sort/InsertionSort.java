package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/8 09:22
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        insertionSort(array);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            ok:
            while (j >= 0) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break ok;
                }
            }
            array[j + 1] = temp;
            System.out.println("排序结果：" + Arrays.toString(array));
        }
    }

}
