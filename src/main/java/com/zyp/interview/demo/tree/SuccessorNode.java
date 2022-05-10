package com.zyp.interview.demo.tree;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/26 13:46
 */
public class SuccessorNode {

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
        Node node11 = new Node(11);

        head.left = node2;
        head.right = node3;
        head.parent = null;

        node2.left = node4;
        node2.parent = head;

        node3.right = node7;
        node3.parent = head;

        node4.left = node5;
        node4.right = node6;
        node4.parent = node2;

        node5.parent = node4;

        node6.left = node8;
        node6.right = node9;
        node6.parent = node4;

        node7.right = node11;
        node7.parent = node3;

        node8.parent = node6;

        node9.right = node10;
        node9.parent = node6;

        node10.parent = node9;

        node11.parent = node7;

        //5,4,8,6,9,10,2,1,3,7,11
        Node tempNode = head;
        final Node successorNode = getSuccessorNode(tempNode);
        System.out.println(tempNode.value + "的后继节点是：" + (successorNode == null ? null : successorNode.value));

    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node n) {
        if (Objects.isNull(n)) {
            return null;
        }
        if (Objects.nonNull(n.right)) {
            return getLeftestNode(n.right);
        } else {
            Node parentNode = n.parent;
            while (Objects.nonNull(parentNode)) {
                if (Objects.equals(parentNode.left, n)) {
                    return parentNode;
                }
                n = parentNode;
                parentNode = n.parent;
            }
        }
        return null;
    }

    public static Node getLeftestNode(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        while (Objects.nonNull(node.left)) {
            node = node.left;
        }
        return node;
    }
}
