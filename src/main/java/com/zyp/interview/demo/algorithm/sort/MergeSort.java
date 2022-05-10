package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/22 13:36
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        process(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void process(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(array, l, mid);
        process(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private static void merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            array[l + j] = help[j];
        }


    }

}
