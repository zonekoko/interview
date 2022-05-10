package com.zyp.interview.demo.graph.algorithm;

import com.google.common.collect.Lists;
import com.zyp.interview.demo.graph.mdoel.Graph;
import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.*;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/12/14 10:24
 */
public class BFS {

    public static void main(String[] args) {
    }
    public static void bfs(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            final Node cur = queue.poll();
            System.out.println(cur.getValue());
            for (Node next : cur.getNexts()) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
