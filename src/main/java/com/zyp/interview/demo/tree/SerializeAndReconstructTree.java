package com.zyp.interview.demo.tree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/26 14:15
 */
public class SerializeAndReconstructTree {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        head.left = node2;
        head.right = node3;

        node2.left = node4;

        node3.right = node7;

        node4.left = node5;
        node4.right = node6;

        node6.left = node8;
        node6.right = node9;

        node9.right = node10;

        //通过先序遍历序列化
//        final String s = serializeByPreOrder(head);
//        System.out.println(s);
//        final Node node = unSerializeByPreOrder1(s);
//        printTree(node);

        final String s = serializeByInOrder(head);
        System.out.println(s);
        final Node node = unSerializeByInOrder1(s);
        printTree(node);


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serializeByPreOrder(Node head) {
        if (Objects.isNull(head)) {
            return "#!";
        }
        String res = head.value + "!";
        res += serializeByPreOrder(head.left);
        res += serializeByPreOrder(head.right);
        return res;
    }

    public static Node unSerializeByPreOrder1(String str) {
        final String[] split = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return unSerializeByPreOrder2(queue);
    }

    public static Node unSerializeByPreOrder2(Queue<String> queue) {
        final String poll = queue.poll();
        if (Objects.equals("#", poll)) {
            return null;
        }
        Node head = new Node(Integer.valueOf(poll));
        head.left = unSerializeByPreOrder2(queue);
        head.right = unSerializeByPreOrder2(queue);
        return head;
    }

    public static String serializeByInOrder(Node head) {
        if (Objects.isNull(head)) {
            return "#!";
        }
        String res = serializeByInOrder(head.left);
        res += head.value + "!";
        res += serializeByInOrder(head.right);
        return res;
    }

    public static Node unSerializeByInOrder1(String str) {
        final String[] split = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return unSerializeByInOrder2(queue);
    }

    private static Node unSerializeByInOrder2(Queue<String> queue) {
        final String poll = queue.poll();
        if (Objects.equals("#", poll)) {
            return null;
        }
        Node left = new Node(Integer.valueOf(poll));
        Node head = new Node();
        head.left = left;
        head = unSerializeByInOrder2(queue);
        head.right = unSerializeByInOrder2(queue);
        return head;
    }
    public static void printTree(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        System.out.println("当前节点：" + head.value + "左子树节点：" + (head.left == null ? null : head.left.value)
                + "右子树节点：" + (head.right == null ? null : head.right.value));
        printTree(head.left);
        printTree(head.right);
    }
}
