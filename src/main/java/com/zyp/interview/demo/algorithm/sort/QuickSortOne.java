package com.zyp.interview.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/22 16:26
 */
public class QuickSortOne {
    /**
     * 问题描述：(荷兰国旗)
     * 给定一个值num，和一个数组array，要求
     * 将比num大的数放在数组的右边，
     * 将比num小的数放在数组的左边，
     * 将和等于num的数放在数组的中间
     */


    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
        int num = 5;
        dutchFlag(array, num);
        System.out.println(Arrays.toString(array));
    }

    private static void dutchFlag(int[] array, int num) {
        int less = -1;
        int i = 0;
        int more = array.length;
        while (i < more) {
            if (i < more && array[i] < num) {
                swap(array, ++less, i++);
            } else if (i < more && array[i] > num) {
                swap(array, --more, i);
            } else if (i < more && array[i] == num) {
                i++;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
