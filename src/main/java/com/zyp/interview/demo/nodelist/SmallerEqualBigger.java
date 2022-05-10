package com.zyp.interview.demo.nodelist;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/15 13:53
 */
public class SmallerEqualBigger {

    public static void main(String[] args) {
        Node  head1 = new Node(2);
        head1.next = new Node(1);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(2);
        printLinkedList(head1);
        final Node node = listPartition(head1, 3);
        printLinkedList(node);
    }



    public static class Node {
        private int value;
        private Node next;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * @param head 链表的头节点
     * @param cv   比较值
     * @return
     */
    public static Node listPartition(Node head, int cv) {
        if (Objects.isNull(head)) {
            return null;
        }
        /** 小于部分的头节点和尾节点 */
        Node sH = null;
        Node sT = null;

        /** 等于部分的头节点和尾节点 */
        Node eH = null;
        Node eT = null;

        /** 大于部分的头节点和尾节点 */
        Node bH = null;
        Node bT = null;

        Node tempNode = head;
        while (Objects.nonNull(head)) {
            tempNode = head.next;
            head.next = null;
            if (head.value < cv) {
                if (Objects.isNull(sH)) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else if (head.value == cv) {
                if (Objects.isNull(eH)) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            } else {
                if (Objects.isNull(bH)) {
                    bH = head;
                } else {
                    bT.next = head;
                }
                bT = head;
            }
            head = tempNode;
        }

        if (Objects.nonNull(sT)) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(Objects.nonNull(eT)){
            eT.next = bH;
        }
        return sH != null ? sH : eH == null ? bH : eH;
    }

    public static void printLinkedList(Node node){
        System.out.println("开始遍历链表：");
        while (Objects.nonNull(node)){
            System.out.println("当前节点值为：" + node.value);
            node = node.next;
        }
    }
}
