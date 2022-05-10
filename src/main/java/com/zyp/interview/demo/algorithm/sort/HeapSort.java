package com.zyp.interview.demo.algorithm.sort;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/25 13:40
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 4, 9, 8, 1, 2, 6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int heapsize = array.length;
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        swap(array, 0, --heapsize);
        while (heapsize > 0) {
            heapify(array, 0, heapsize);
            swap(array, 0, --heapsize);
        }
    }

    private static void heapInsert(int[] array, int index) {
        int parent = Math.max((index - 1) >> 1, 0);
        while (array[index] > array[parent]) {
            swap(array, index, parent);
            index = parent;
            parent = Math.max((index - 1) >> 1, 0);
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int leftChild = index * 2 + 1;
        while (leftChild < heapSize) {
            int largest = ((leftChild + 1) >= heapSize || array[leftChild] > array[leftChild + 1]) ? leftChild : leftChild + 1;
            largest = array[index] > array[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(array, index, largest);
            index = largest;
            leftChild = index * 2 + 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
