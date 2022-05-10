package com.zyp.interview.demo.graph.algorithm;

import com.zyp.interview.demo.graph.mdoel.Graph;
import com.zyp.interview.demo.graph.mdoel.Node;

import java.util.*;

/**
 * @author zyp
 * @version V1.0
 * @Date 2021/12/14 11:06
 * @Description 拓扑排序
 */
public class TopologySort {
    public static void main(String[] args) {

    }

    public static List<Node> topologySort(Graph graph) {
        if (Objects.isNull(graph)) {
            return new ArrayList<>();
        }
        /** Map<节点,节点的入度值> */
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroNodes = new LinkedList<>();
        for (Node node : graph.getNodes().values()) {
            inMap.put(node, node.getIn());
            if (node.getIn() == 0) {
                zeroNodes.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroNodes.isEmpty()) {
            final Node cur = zeroNodes.poll();
            result.add(cur);
            for (Node next : cur.getNexts()) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroNodes.add(cur);
                }
            }
        }
        return result;
    }
}
