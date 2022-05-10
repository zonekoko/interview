package com.zyp.interview.demo.greedy;

import javax.validation.constraints.Min;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 16:12
 * @Description 一块金条切成两半，
 * 是需要花费和长度数值一样的铜板的。
 * 比如长度为20的金条，
 * 不管切成长度多大的两半，
 * 都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板?
 * 例如,给定数组{10,20,30}，
 * 代表一共三个人，
 * 整块金条长度为10+20+30=60。
 * 金条要分成10,20,30三个部分。
 * 如果先把长度60的金条分成10和50，
 * 花费60；
 * 再把长度50的金条分成20和30，
 * 花费50；
 * 一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，
 * 花费60；
 * 再把长度30金条分成10和20，
 * 花费30；
 * 一共花费90铜板。
 * 输入一个数组，
 * 返回分割的最小代价。
 */
public class LessMoneySplitGold {

    public static void main(String[] args) {
        int[] array = {10,20,30};
        System.out.println(lessMoney(array));
    }

    public static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static Integer lessMoney(int[] array){
        if(Objects.isNull(array) || array.length == 0){
            return 0;
        }
        //小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MinComparator());
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
        int sum = 0;
        while (queue.size() > 1){
            sum += queue.poll() + queue.poll();
            queue.add(sum);
        }
        return sum;

    }


}
