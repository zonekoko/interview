package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/8 14:14
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        /** 单边循环 */
//        final int p = unilateral(array, l, h);
//        quickSort(array, l, p - 1);
//        quickSort(array, p + 1, h);

        /** 双边循环 */
        final int p = bilateral(array, l, h);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, h);
    }

    private static int unilateral(int[] array, int l, int h) {
        int pv = h;
        int i = l;
        for (int j = l; j < h; j++) {
            if (array[j] < array[pv]) {
                if (j != i) {
                    swap(array, i, j);
                }
                i++;
            }
        }
        if (i != h) {
            swap(array, i, pv);
        }
        System.out.println("排序结果：" + Arrays.toString(array));
        return i;
    }

    private static int bilateral(int[] array, int l, int h) {
        int pv = l;//基准点
        int i = l;
        int j = h;
        while (i < j) {
            while (i < j && array[j] > array[pv]) {
                j--;
            }
            while (i < j && array[i] <= array[pv]) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, pv, i);
        System.out.println("排序结果：" + Arrays.toString(array));
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
