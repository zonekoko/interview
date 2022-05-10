package com.zyp.interview.demo.nodelist;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/17 11:20
 */
public class FindFirstIntersectNode {

    public static void main(String[] args) {

        Node head1 = new Node(1);
        Node head2 = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        head1.next = node2;
        head1.next.next = node3;
        head1.next.next.next = node4;
        head1.next.next.next.next = node5;
        head1.next.next.next.next.next = node4;

        head2.next = node3;
        final Node node = findFirstIntersectNode(head1, head2);
        System.out.println("第一个相交的节点是：" + (node == null ? null : node.value));
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node checkCircle(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return null;
        }
        Node lowNode = head.next;
        Node fastNode = head.next.next;
        while (!Objects.equals(lowNode, fastNode)) {
            if (Objects.isNull(fastNode.next) || Objects.isNull(fastNode.next.next)) {
                return null;
            } else {
                lowNode = lowNode.next;
                fastNode = fastNode.next.next;
            }
        }
        fastNode = head;
        while (!Objects.equals(lowNode, fastNode)) {
            fastNode = fastNode.next;
            lowNode = lowNode.next;
        }
        return lowNode;
    }

    public static Node findFirstIntersectNode(Node head1, Node head2) {
        if (Objects.isNull(head1) || Objects.isNull(head2)) {
            return null;
        }
        Node circleNode1 = checkCircle(head1);
        Node circleNode2 = checkCircle(head2);
        if (Objects.isNull(circleNode1) && Objects.isNull(circleNode2)) {
            return noLoop(head1, head2);
        } else if (Objects.nonNull(circleNode1) && Objects.nonNull(circleNode2)) {
            return bothLoop(head1, circleNode1, head2, circleNode2);
        }
        return null;
    }

    public static Node noLoop(Node head1, Node head2) {
        int len = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (Objects.nonNull(cur1.next)) {
            //遍历第一个链表
            cur1 = cur1.next;
            len++;
        }
        while (Objects.nonNull(cur2.next)) {
            cur2 = cur2.next;
            len--;
        }
        if (!Objects.equals(cur1, cur2)) {
            return null;
        }
        cur1 = len >= 0 ? head1 : head2;
        cur2 = len >= 0 ? head2 : head1;
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        while (!Objects.equals(cur1, cur2)) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (Objects.equals(loop1, loop2)) {
            cur1 = head1;
            cur2 = head2;
            int len = 0;
            while (cur1 != loop1) {
                len++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                len--;
                cur2 = cur2.next;
            }
            cur1 = len >= 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            len = Math.abs(len);
            while (len != 0) {
                len--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }

}
