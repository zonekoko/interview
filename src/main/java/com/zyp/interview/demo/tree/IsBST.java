package com.zyp.interview.demo.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.util.Pair;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/22 15:28
 * 判断一个树是否是搜索二叉树
 */
public class IsBST {
    public static void main(String[] args) {

        /** 第一棵树 */
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);


        head1.left = node2;
        head1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node5.right = node6;

        node3.left = node7;
        node3.right = node8;

        node7.left = node9;

        /** 第二棵树 */
        Node head2 = new Node(6);
        Node n3 = new Node(3);
        Node n9 = new Node(9);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        Node n12 = new Node(12);
        Node n4 = new Node(4);
        Node n8 = new Node(8);
        Node n11 = new Node(11);

        head2.left = n3;
        head2.right = n9;

        n3.left = n2;
        n3.right = n5;

        n5.left = n4;

        n9.left = n7;
        n9.right = n12;

        n7.right = n8;

        n12.left = n11;

//        boolean one = isBST(head1);
//        boolean two = isBST(head2);
//
//        System.out.println("第一棵树是二叉搜索树?" + one);
//        System.out.println("第二棵树是二叉搜索树？" + two);

        final boolean one2 = isBST2(head1);
        final boolean two2 = isBST2(head2);
        System.out.println("第一棵树是二叉搜索树？" + one2);
        System.out.println("第二棵树是二叉搜索树？" + two2);


    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReturnInfo {
        private boolean isBST;
        private int minValue;
        private int maxValue;

        public ReturnInfo(boolean flag) {
            this.isBST = flag;
        }
    }

    public static boolean isBST(Node head) {
        if (Objects.isNull(head)) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        process(head, queue);

        int pre = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (pre >= node.value) {
                return false;
            }
            pre = node.value;
        }
        return true;
    }

    public static boolean isBST2(Node head) {
        final ReturnInfo returnInfo = process2(head);
        boolean isBST = true;
        if (Objects.nonNull(returnInfo) && !returnInfo.isBST) {
            isBST = false;
        }
        return isBST;
    }

    private static void process(Node head, Queue<Node> queue) {
        if (Objects.isNull(head)) {
            return;
        }
        process(head.left, queue);
        queue.add(head);
        process(head.right, queue);
    }

    public static ReturnInfo process2(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        int min = head.value;
        int max = head.value;
        boolean isBST = true;

        ReturnInfo leftReturnInfo = process2(head.left);
        ReturnInfo rightReturnInfo = process2(head.right);

        if (Objects.nonNull(leftReturnInfo)) {
            min = Math.min(min, leftReturnInfo.getMinValue());
            max = Math.max(max, leftReturnInfo.getMaxValue());
        }

        if (Objects.nonNull(rightReturnInfo)) {
            min = Math.min(min, rightReturnInfo.getMinValue());
            max = Math.max(max, rightReturnInfo.getMaxValue());
        }
        if (Objects.nonNull(leftReturnInfo) && (!leftReturnInfo.isBST || leftReturnInfo.getMaxValue() > head.value)) {
            isBST = false;
        }
        if (Objects.nonNull(rightReturnInfo) && (!rightReturnInfo.isBST || rightReturnInfo.getMinValue() < head.value)) {
            isBST = false;
        }

        return new ReturnInfo(isBST, min, max);

    }
}
