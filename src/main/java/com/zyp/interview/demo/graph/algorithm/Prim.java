package com.zyp.interview.demo.graph.algorithm;

import com.zyp.interview.demo.graph.mdoel.Edge;
import com.zyp.interview.demo.graph.mdoel.Graph;
import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.*;

/**
 * @author zyp
 * @version V1.0
 * @Date 2021/12/15 10:07
 * @Description TODO
 */
public class Prim {

    public static void main(String[] args) {

    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }

    public static Set<Edge> prim(Graph graph) {
        if (Objects.isNull(graph)) {
            return new HashSet<>();
        }

        Set<Edge> result = new HashSet<>();
        Set<Node> sameNodes = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());

        for (Node node : graph.getNodes().values()) {
            if (!sameNodes.contains(node)) {
                sameNodes.add(node);

                for (Edge edge : node.getEdges()) {
                    queue.add(edge);
                }
                while (!queue.isEmpty()) {
                    final Edge cur = queue.poll();
                    final Node toNode = cur.getTo();
                    if (!sameNodes.contains(toNode)) {
                        result.add(cur);
                        sameNodes.add(toNode);
                    }
                    for (Edge edge : toNode.getEdges()) {
                        queue.add(edge);
                    }
                }
            }
        }
        return result;
    }
}
