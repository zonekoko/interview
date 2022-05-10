package com.zyp.interview.demo.algorithm.sort;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/22 14:42
 */
public class LittleSum {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 5};
        final int count = process(array, 0, array.length - 1);
        System.out.println(count);
    }

    private static int process(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        final int process = process(array, l, mid);
        final int process1 = process(array, mid + 1, r);
        final int merge = merge(array, l, mid, r);
        return process + process1 + merge;
    }

    private static int merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int merge = 0;
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (array[p1] < array[p2]) {
                merge += ((r - p2 + 1) * array[p1]);
                help[i++] = array[p1++];
            }
            if (array[p1] >= array[p2]) {
                help[i++] = array[p2++];
            }
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
