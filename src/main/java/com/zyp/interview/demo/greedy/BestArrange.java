package com.zyp.interview.demo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 16:33
 * @Description 一些项目要占用一个会议室宣讲，
 * 会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组，里面是一个个具体的项目)，
 * 你来安排宣讲的日程，
 * 要求会议室进行的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 */
public class BestArrange {

    public static void main(String[] args) {

    }

    public static class Program {
        private int start;

        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] array,int start) {
        if (Objects.isNull(array) || array.length == 0) {
            return 0;
        }
        int count = 0;
        int temEnd = 0;
        Arrays.sort(array, new MyComparator());
        for (int i = 0; i < array.length; i++) {
            if(array[i].start >= start){
                count++;
                start = array[i].end;
            }
        }
        return count;


    }

    public static class MyComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
