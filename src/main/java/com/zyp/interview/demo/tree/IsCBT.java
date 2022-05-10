package com.zyp.interview.demo.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/22 16:39
 * 判断一棵树是不是完全二叉树
 */
public class IsCBT {
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
        Node head2 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        head2.left = n2;
        head2.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        n5.left = n10;

        final boolean one1 = isCBT(head1);
        final boolean two1 = isCBT(head2);

        System.out.println("第一棵树是否是完全二叉树？"+ one1);
        System.out.println("第二棵树是否是完全二叉树？"+ two1);


    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (Objects.isNull(head)) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;

        Node left = null;
        Node right = null;
        Node curNode = null;

        while (!queue.isEmpty()) {
            curNode = queue.poll();
            left = curNode.left;
            right = curNode.right;
            if ((leaf &&
                    (Objects.nonNull(left) || Objects.nonNull(right)))
                    || (Objects.nonNull(right) && Objects.isNull(left))) {
                return false;
            }
            if (Objects.nonNull(left)) {
                queue.add(left);
            }
            if (Objects.nonNull(right)) {
                queue.add(right);
            }
            if (Objects.isNull(left) && Objects.isNull(right)) {
                leaf = true;
            }
        }
        return true;
    }
}
