package com.zyp.interview.demo.graph.algorithm;

import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * @author zyp
 * @version V1.0
 * @time 2021/12/14 10:25
 */
public class DFS {

    public static void main(String[] args) {

    }

    public static void dfs(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        set.add(node);
        stack.push(node);
        while (!stack.isEmpty()) {
            final Node cur = stack.pop();
            for (Node next : cur.getNexts()) {
                System.out.println(cur.getValue());
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }
}
