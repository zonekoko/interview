package com.zyp.interview.demo.nodelist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/11 16:50
 * 单链表反转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);
        DoubleNode doubleNode5 = new DoubleNode(5);
        DoubleNode doubleNode6 = new DoubleNode(6);
        head2.next = doubleNode2;head2.pre = null;
        doubleNode2.next = doubleNode3;doubleNode2.pre = head2;
        doubleNode3.next = doubleNode4;doubleNode3.pre = doubleNode2;
        doubleNode4.next = doubleNode5;doubleNode4.pre = doubleNode3;
        doubleNode5.next = doubleNode6;doubleNode5.pre = doubleNode4;
        doubleNode6.next = null;doubleNode6.pre = doubleNode5;
        printDoubleLinkedList(head2);
        head2 = reverseDoubleList(head2);
        printDoubleLinkedList(head2);

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next;
        while (Objects.nonNull(head)) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.println("LinkedList:");
        while (Objects.nonNull(head)) {
            if(Objects.nonNull(head.next)){
                System.out.println("目前：" + head.getValue()+"next:" + head.next.getValue());
            }else{
                System.out.println("目前：" + head.getValue()+"next: null" );
            }

            head = head.next;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DoubleNode {
        int value;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(int data){
            this.value = data;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (Objects.nonNull(head)){
            next= head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println("Double linked list:");
        while (Objects.nonNull(head)){
            if(Objects.nonNull(head.pre)){
                System.out.print("pre:" + head.pre.getValue() + "");
            }else{
                System.out.print("pre: null" + "");
            }
            if(Objects.nonNull(head.next)){
                System.out.println("next:" + head.next.getValue());
            }else{
                System.out.println("next: null" );
            }
            head = head.next;
        }
    }
}
