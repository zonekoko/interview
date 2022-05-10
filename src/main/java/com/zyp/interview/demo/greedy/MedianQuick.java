package com.zyp.interview.demo.greedy;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @ClassName MadianQuick
 * @Description 一个数据流中，随时可以取得中位数
 * @Author zhangyanping
 * @Date 2022/1/21 14:03
 * @Version 1.0
 */
public class MedianQuick {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6};
        BigDecimal i = madianHandler(array);
        System.out.println(i);

    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static BigDecimal madianHandler(int[] array) {
        if (Objects.isNull(array)) {
            return new BigDecimal(0);
        }

        //大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        //小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < array.length; i++) {
            if (maxHeap.isEmpty() || array[i] <= maxHeap.peek()) {
                maxHeap.add(array[i]);
            } else {
                minHeap.add(array[i]);
            }

            //每加完一个数，进行两个堆的平衡化
            balanceTwoHeap(maxHeap, minHeap);
        }

        //取出中位数
        BigDecimal median = getMedian(maxHeap, minHeap);

        return median;

    }

    private static BigDecimal getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        Integer maxHeapTop = maxHeap.peek();
        Integer minHeapTop = minHeap.peek();

        maxHeapTop = maxHeapTop == null ? 0 : maxHeapTop;
        minHeapTop = minHeapTop == null ? 0 : minHeapSize;

        if(((maxHeapSize+minHeapSize) & 1) ==0){
            return new BigDecimal((maxHeapTop + minHeapTop) / 2);
        }else{
            return new BigDecimal(maxHeapSize > minHeapSize ? maxHeapTop : minHeapTop);
        }
    }

    private static void balanceTwoHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }
    }


}
