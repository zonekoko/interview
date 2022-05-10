package com.zyp.interview.demo.algorithm.binarysearch;


import lombok.extern.slf4j.Slf4j;

/**
 * @author zyp
 * @Description 二分查找法
 * @Date 2021/9/30 10:45
 */
@Slf4j
public class BinarySearchOne {

    public static void main(String[] args) {
        int[] integerArray = new int[]{1, 5, 7, 56, 78, 189, 290, 333, 345, 789, 1240, 3450, 7230, 7240, 7789, 8907};
        final int index = binarySearch(integerArray, 456);
        System.out.println(index);
    }


    private static int binarySearch(int[] array, int search) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (array[mid] == search) {
                return mid;
            } else if (array[mid] < search) {
                l = mid + 1;
            } else if (array[mid] > search) {
                r = mid - 1;
            }
        }
        return -1;
    }
}
