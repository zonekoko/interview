package com.zyp.interview.demo.nodelist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/12 14:06
 */
public class CheckPalindrome {

    public static void main(String[] args) {
        Node head1 = null;
        printLinkedList(head1);
        System.out.println("head1是否是回文：" + checkPalinedrome(head1));
        printLinkedList(head1);
        System.out.println("===============================");


        Node head2 = new Node(1);
        printLinkedList(head2);
        System.out.println("head2是否是回文：" + checkPalinedrome(head2));
        printLinkedList(head2);
        System.out.println("===============================");

        Node head3 = new Node(1);
        head3.next = new Node(1);
        printLinkedList(head3);
        System.out.println("head3是否是回文：" + checkPalinedrome(head3));
        printLinkedList(head3);
        System.out.println("===============================");

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(1);
        printLinkedList(head4);
        System.out.println("head4是是否是回文：" + checkPalinedrome(head4));
        printLinkedList(head4);
        System.out.println("===============================");

        Node head5 = new Node(1);
        head5.next = new Node(2);
        head5.next.next = new Node(2);
        head5.next.next.next = new Node(1);
        printLinkedList(head5);
        System.out.println("head5是否是回文：" + checkPalinedrome(head5));
        printLinkedList(head5);
        System.out.println("===============================");

        Node head6 = new Node(1);
        head6.next = new Node(2);
        head6.next.next = new Node(3);
        head6.next.next.next = new Node(4);
        head6.next.next.next.next = new Node(3);
        head6.next.next.next.next.next = new Node(2);
        head6.next.next.next.next.next.next = new Node(1);
        printLinkedList(head6);
        System.out.println("head6是否是回文：" + checkPalinedrome(head6));
        printLinkedList(head6);

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean checkPalinedrome(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }
        Node lowNode = head;
        Node fastNode = head;

        //快慢指针，当快指针走到最后一个节点或者倒数第二个节点时停止
        while (Objects.nonNull(fastNode.next) && Objects.nonNull(fastNode.next.next)) {
            lowNode = lowNode.next;
            fastNode = fastNode.next.next;
        }
        //慢节点的下一个节点就是右半部分的头节点
        fastNode = lowNode.next;
        //反转右半部分的链表
        lowNode.next = null;
        Node tempNode;
        while (Objects.nonNull(fastNode)) {
            tempNode = fastNode.next;
            fastNode.next = lowNode;
            lowNode = fastNode;
            fastNode = tempNode;
        }
        //记录最后一个节点
        tempNode = lowNode;
        fastNode = head;
        boolean res = true;
        while (Objects.nonNull(lowNode) && Objects.nonNull(fastNode)) {
            if (!(Objects.equals(lowNode.getValue(), fastNode.getValue()))) {
                res = false;
                break;
            }
            lowNode = lowNode.next;
            fastNode = fastNode.next;
        }
        //将链表反转回来
        fastNode = tempNode.next;
        tempNode.next = null;
        while (Objects.nonNull(fastNode)) {
            lowNode = fastNode.next;
            fastNode.next = tempNode;
            tempNode = fastNode;
            fastNode = lowNode;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.println("开始遍历链表：");
        while (Objects.nonNull(node)) {
            System.out.println("当前节点的值为：" + node.getValue());
            node = node.next;
        }
    }
}
