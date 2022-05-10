package com.zyp.interview.demo.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/22 17:06
 * 判断一棵树是否是平衡二叉树
 */
public class IsBalancedTree {

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
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        head2.left = n2;
        head2.right = n3;

        n2.left = n4;
        n2.right = n5;

        n4.left = n6;
        n4.right = n7;

        n6.left = n8;
        n6.right = n9;

        n5.left = n10;

        n8.left = n11;
        n8.right = n12;


        ReturnInfo balanced = isBalanced(head1);
        ReturnInfo balanced2 = isBalanced(head2);
        System.out.println("第一棵树是否是平衡二叉树：" + balanced.isBalanced);
        System.out.println("第二棵树是否是平衡二叉树：" + balanced2.isBalanced);
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
        private boolean isBalanced;
        private int height;
    }

    public static ReturnInfo isBalanced(Node head) {
        if (Objects.isNull(head)) {
            return new ReturnInfo(true, 0);
        }

        final ReturnInfo leftReturnInfo = isBalanced(head.left);
        final ReturnInfo rightReturnInfo = isBalanced(head.right);

        int height = Math.max(leftReturnInfo.getHeight(), rightReturnInfo.height) + 1;

        boolean isBalanced = leftReturnInfo.isBalanced()
                && rightReturnInfo.isBalanced()
                && Math.abs(leftReturnInfo.getHeight() - rightReturnInfo.getHeight()) < 2;

        return new ReturnInfo(isBalanced, height);
    }

}
