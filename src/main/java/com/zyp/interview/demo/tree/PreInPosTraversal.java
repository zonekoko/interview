package com.zyp.interview.demo.tree;

import java.util.Objects;
import java.util.Stack;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/19 11:13
 */
public class PreInPosTraversal {

    public static void main(String[] args) {
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

        /**
         * 递归
         */
//        preOrderRecursive(head1);
//        System.out.println("============");
//        inOrderRecursive(head1);
//        System.out.println("============");
//        posOrderRecursive(head1);

        /**
         * 非递归
         */
//        preOrderUnRecursive(head1);
//        inOrderUnRecursive(head1);
//        posOrderUnRecursive(head1);
        posOrderUnRecursive2(head1);

    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归先序遍历
     *
     * @param head
     */
    public static void preOrderRecursive(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        System.out.print("先序：" + head.value + "");
        preOrderRecursive(head.left);
        preOrderRecursive(head.right);
    }

    /**
     * 递归中序遍历
     *
     * @param head
     */
    public static void inOrderRecursive(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        inOrderRecursive(head.left);
        System.out.print("中序 ：" + head.value + "");
        inOrderRecursive(head.right);
    }

    /**
     * 递归后序遍历
     *
     * @param head
     */
    public static void posOrderRecursive(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        posOrderRecursive(head.left);
        posOrderRecursive(head.right);
        System.out.print("后序：" + head.value + "");
    }

    /**
     * 非递归先序遍历
     *
     * @param head
     */
    public static void preOrderUnRecursive(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            final Node rootNode = stack.pop();
            System.out.print("非递归先序：" + rootNode.value);
            if (Objects.nonNull(rootNode.right)) {
                stack.push(rootNode.right);
            }
            if (Objects.nonNull(rootNode.left)) {
                stack.push(rootNode.left);
            }
        }
    }

    public static void inOrderUnRecursive(Node head) {
        if (Objects.nonNull(head)) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || Objects.nonNull(head)) {
                if (Objects.nonNull(head)) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print("非递归中序遍历：" + head.value);
                    head = head.right;
                }
            }
        }
    }

    public static void posOrderUnRecursive(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            final Node node = stack1.pop();
            stack2.push(node);
            if (Objects.nonNull(node.left)) {
                stack1.push(node.left);
            }
            if (Objects.nonNull(node.right)) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            final Node node = stack2.pop();
            System.out.println("非递归后序遍历1：" + node.value);
        }
    }

    public static void posOrderUnRecursive2(Node head) {
        if (Objects.isNull(head)) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node tempNode = null;
        stack.push(head);
        while (!stack.isEmpty()) {
            tempNode = stack.peek();
            if(         Objects.nonNull(tempNode.left)
                    && !(Objects.equals(head,tempNode.left))
                    && !(Objects.equals(head,tempNode.right))
            ){
               stack.push(tempNode.left);
            }else if(Objects.nonNull(tempNode.right) && !(Objects.equals(head,tempNode.right))){
                stack.push(tempNode.right);
            }else{
                System.out.print("非递归后序遍历2：" + stack.pop().value);
                head = tempNode;
            }
        }
    }
}
