package com.zyp.interview.demo.nodelist;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/17 09:02
 */
public class CopyListWithRandom {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        head1.next = node2;
        head1.next.next = node3;
        head1.next.next.next = node5;
        head1.next.next.next.next = node4;
        head1.next.next.next.next.next = node6;
        head1.rand = node3;
        head1.next.next.next.rand = node6;
        printLinkedList(head1);
        System.out.println(head1);
        final Node node = copyListWithRandom(head1);
        printLinkedList(node);
        System.out.println(node);
    }

    public static class Node {
        private int value;
        private Node next;
        private Node rand;

        public Node(int val) {
            this.value = val;
        }
    }

    public static Node copyListWithRandom(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Node tempNode = head;
        Node nextNode = null;
        Node newNode = null;
        while (Objects.nonNull(tempNode)) {
            nextNode = tempNode.next;
            newNode = new Node(tempNode.value);
            tempNode.next = newNode;
            newNode.next = nextNode;
            tempNode = nextNode;
        }
        tempNode = head;
        Node randNode = null;
        while (Objects.nonNull(tempNode) && Objects.nonNull(tempNode.next)) {
            randNode = tempNode.rand;
            tempNode.next.rand = randNode == null ? null : randNode.next;
            tempNode = tempNode.next.next;
        }
        tempNode = head;
        newNode = tempNode.next;
        while (Objects.nonNull(tempNode) && Objects.nonNull(tempNode.next)) {
            nextNode = tempNode.next;
            tempNode = tempNode.next.next;
            nextNode.next = tempNode == null ? null : tempNode.next;
        }
        return newNode;
    }

    public static void printLinkedList(Node head) {
        System.out.println("开始遍历链表：");
        while (Objects.nonNull(head)) {
            System.out.print("当前节点值：" + head.value);
            System.out.print("当前节点的rand节点值：" + (head.rand == null ? null : head.rand.value));
            System.out.println("当前节点的next节点值：" + (head.next == null ? null : head.next.value));
            head = head.next;
        }
    }
}
