package com.zyp.interview.demo.tree;


import org.apache.commons.collections4.MapUtils;

import java.util.*;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/25 13:49
 */
public class LowestCommonAncestor {

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

//        final Node lowestCommonAncestor1 = getLowestCommonAncestor1(head, node9, node9);
//        System.out.println("最小公共祖先1：" + lowestCommonAncestor1.value);

        final Node lowestCommonAncestor2 = getLowestCommonAncestor2(head, node8, node5);
        System.out.println("最小公共祖先2：" + lowestCommonAncestor2.value);


    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getLowestCommonAncestor1(Node head, Node o1, Node o2) {
        if (Objects.isNull(head) || Objects.isNull(o1) || Objects.isNull(o2)) {
            return null;
        }
        Map<Node, Node> fatherMap = getFatherMap(head);
        fatherMap.put(head, null);
        if (MapUtils.isEmpty(fatherMap)) {
            return null;
        }
        Node fatherNode = fatherMap.get(o1);
        Set<Node> set = new HashSet<>();
        set.add(o1);
        while (Objects.nonNull(fatherNode)) {
            set.add(fatherNode);
            fatherNode = fatherMap.get(fatherNode);
        }

        if (set.contains(o2)) {
            return o2;
        }

        Node fatherNode2 = fatherMap.get(o2);
        while (Objects.nonNull(fatherNode2)) {
            if (set.contains(fatherNode2)) {
                return fatherNode2;
            }
            fatherNode2 = fatherMap.get(fatherNode2);
        }
        return null;
    }

    public static Node getLowestCommonAncestor2(Node head, Node o1, Node o2) {
        if (Objects.isNull(head) || Objects.equals(head, o1) || Objects.equals(head, o2)) {
            return head;
        }

        final Node leftNode = getLowestCommonAncestor2(head.left, o1, o2);
        final Node rightNode = getLowestCommonAncestor2(head.right, o1, o2);
        if (Objects.nonNull(leftNode) && Objects.nonNull(rightNode)) {
            return head;
        }

        return Objects.nonNull(leftNode) ? leftNode : rightNode;

    }

    private static Map<Node, Node> getFatherMap(Node head) {
        if (Objects.isNull(head)) {
            return new HashMap<>();
        }
        Map<Node, Node> fatherMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node tempNode = null;
        while (!queue.isEmpty()) {
            tempNode = queue.poll();
            if (Objects.nonNull(tempNode.left)) {
                queue.add(tempNode.left);
                fatherMap.put(tempNode.left, tempNode);
            }
            if (Objects.nonNull(tempNode.right)) {
                queue.add(tempNode.right);
                fatherMap.put(tempNode.right, tempNode);
            }
        }
        return fatherMap;
    }
}
