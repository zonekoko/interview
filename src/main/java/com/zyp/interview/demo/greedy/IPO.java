package com.zyp.interview.demo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName IPO
 * @Description 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数m
 * 含义：
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：
 * 你每做完一个项目，
 * 马上获得的收益，
 * 可以支持你去做下一个项目。
 * 输出：
 * 你最后获得的最大钱数。
 * @Author zhangyanping
 * @Date 2022/1/21 13:12
 * @Version 1.0
 */
public class IPO {

    public static void main(String[] args) {

    }

    public static class Node{

        /** 花费 */
        private int p;
        /** 利润 */
        private int c;

        public Node(int p,int c){
            this.p = p;
            this.c = c;
        }
    }

    public static class MaxComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static class MinComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static int findMaximizedCapital(int k,int m,int[] profits,int[] costs){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], costs[i]);
        }
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(new MinComparator());
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(new MaxComparator());
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().c <= m){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty()){
                return m;
            }
            m+=maxProfitQueue.poll().p;
        }
        return m;
    }
}
