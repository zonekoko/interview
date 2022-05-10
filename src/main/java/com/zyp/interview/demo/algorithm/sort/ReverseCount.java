package com.zyp.interview.demo.algorithm.sort;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/22 15:21
 */
public class ReverseCount {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 5, 0};
        int count = process(array, 0, array.length - 1);
        System.out.println(count);
    }

    private static int process(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        final int process = process(array, l, mid);
        final int process1 = process(array, mid + 1, r);
        int merge = merge(array, l, mid, r);

        return process + process1 + merge;
    }

    private static int merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int merge = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            merge += array[p1] > array[p2] ? r - p2 + 1 : 0;
            help[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length - 1; j++) {
            array[l + j] = help[j];
        }

        return merge;
    }
}
