package com.zyp.interview.demo.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/22 14:02
 */
public class TreeMaxWidth {

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

//        final int maxWidth1 = searchMaxWidth1(head1);
//        System.out.println(maxWidth1);
        final int maxWidth2 = searchMaxWidth2(head1);
        System.out.println(maxWidth2);
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int searchMaxWidth1(Node head) {
        if (Objects.isNull(head)) {
            return 0;
        }
        int curLevel = 0;
        int maxWidth = 0;
        int curWidth = 0;
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(head, 1);
        queue.add(head);
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (Objects.nonNull(node.left)) {
                map.put(node.left, map.get(node) + 1);
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                map.put(node.right, map.get(node) + 1);
                queue.add(node.right);
            }
            if (map.get(node) > curLevel) {
                curLevel = map.get(node);
                curWidth = 1;
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }

    public static int searchMaxWidth2(Node head) {
        if (Objects.isNull(head)) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int maxWidth = 0;
        int curWidth = 1;
        Node curFinalNode = head;
        Node nextFinalNode = null;
        queue.add(curFinalNode);
        Node curNode = null;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if(Objects.nonNull(curNode.left)){
                queue.add(curNode.left);
                nextFinalNode = curNode.left;
            }
            if(Objects.nonNull(curNode.right)){
                queue.add(curNode.right);
                nextFinalNode = curNode.right;
            }
            if(Objects.equals(curNode,curFinalNode)){
                maxWidth = Math.max(maxWidth,curWidth);
                curWidth = 1;
                curFinalNode = nextFinalNode;
                nextFinalNode = null;
            }else{
                curWidth++;
            }
        }
        return maxWidth;
    }
}
