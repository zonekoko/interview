package com.zyp.interview.demo.graph.algorithm;

import com.zyp.interview.demo.graph.mdoel.Edge;
import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.*;

/**
 * @author zyp
 * @version V1.0
 * @Date 2021/12/16 13:35
 * @Description TODO
 */
public class Dijkstra {

    public static void main(String[] args) {
        System.out.println("Hello word");
    }

    public static Map<Node, Integer> dijkstra1(Node head) {
        if (Objects.isNull(head)) {
            return new HashMap<>();
        }
        /** 源点到各个点的距离，如果没有表示到这个点的距离为无穷大 */
        Map<Node, Integer> distanceMap = new HashMap<>();
        /** 已经锁死不会再改变的源点到各个点的距离 */
        Set<Node> selectedSet = new HashSet<>();
        distanceMap.put(head, 0);
        //获取distanceMap中距离最短的点
        Node minNode = getMinDistanceAndUnSelectedNodeFromMap(distanceMap, selectedSet);
        while (Objects.nonNull(minNode)) {
            final Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.getEdges()) {
                final Node toNode = edge.getTo();
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.getWeight());
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.getWeight()));
                }
            }
            selectedSet.add(minNode);
            minNode = getMinDistanceAndUnSelectedNodeFromMap(distanceMap, selectedSet);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnSelectedNodeFromMap(Map<Node, Integer> distanceMap, Set<Node> selectedSet) {
        Node minNode = null;
        Integer minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> distanceEntry : distanceMap.entrySet()) {
            Node node = distanceEntry.getKey();
            Integer distance = distanceEntry.getValue();
            if (!selectedSet.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
