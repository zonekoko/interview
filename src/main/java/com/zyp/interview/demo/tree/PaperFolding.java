package com.zyp.interview.demo.tree;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/29 14:32
 */
public class PaperFolding {

    public static void main(String[] args) {
        process(1, 4, true);
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        process(i + 1, n, false);
    }
}
