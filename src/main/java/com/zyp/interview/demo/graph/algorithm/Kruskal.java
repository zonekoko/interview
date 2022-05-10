package com.zyp.interview.demo.graph.algorithm;

import com.zyp.interview.demo.graph.mdoel.Edge;
import com.zyp.interview.demo.graph.mdoel.Graph;
import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.*;

/**
 * @author zyp
 * @version V1.0
 * @Date 2021/12/14 13:22
 * @Description Kruskal算法
 */
public class Kruskal {
    public static void main(String[] args) {
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }

    public static class FindCircle {

        public Map<Node, List<Node>> myset = new HashMap<>();

        public void initMap(Collection<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(node);
                myset.put(node, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            final List<Node> fromNodeList = myset.get(from);
            final List<Node> toNodeList = myset.get(to);
            return fromNodeList == toNodeList;
        }

        public void union(Node from, Node to) {
            final List<Node> fromNodeList = myset.get(from);
            final List<Node> toNodeList = myset.get(to);
            for (Node cur : toNodeList) {
                fromNodeList.add(cur);
                myset.put(cur, fromNodeList);
            }
        }
    }

    public static Set<Edge> kruskal(Graph graph) {
        if (Objects.isNull(graph)) {
            return new HashSet<>();
        }
        final FindCircle findCircle = new FindCircle();
        findCircle.initMap(graph.getNodes().values());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.getEdges()) {
            priorityQueue.add(edge);
        }

        Set<Edge> result = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            final Edge cur = priorityQueue.poll();
            final Node from = cur.getFrom();
            final Node to = cur.getTo();
            final boolean sameSet = findCircle.isSameSet(from, to);
            if (!sameSet) {
                result.add(cur);
                findCircle.union(from, to);
            }
        }
        return result;
    }
}
