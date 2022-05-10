package com.zyp.interview.demo.graph.mdoel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/12/2 13:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graph {

    private HashMap<Integer,Node> nodes;

    private HashSet<Edge> edges;


}
