package com.zyp.interview.demo.algorithm.sort;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/2 07:18
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
//        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
//        bubbleSort(array);
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(2);
        BigDecimal b3 = new BigDecimal(3);
        BigDecimal b4 = new BigDecimal(4);
        BigDecimal b5 = new BigDecimal(5);
        ArrayList<BigDecimal> lists = Lists.newArrayList(b1, b2, b3, b4, b5);
//        BigDecimal result = lists.stream().reduce(BigDecimal::add).orElse(new BigDecimal(0));
        BigDecimal result = lists.stream().reduce(new BigDecimal(5),BigDecimal::add);
        System.out.println(result);
    }

    private static void bubbleSort(int[] array) {
        int temp = array.length - 1;
        while (temp > 0) {
            int last = 0;
            for (int j = 0; j < temp; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    last = j;
                }
                System.out.println("第" + (j + 1) + "次比较结果：" + Arrays.toString(array));
            }
            temp = last;
            System.out.println("冒泡啦");
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
