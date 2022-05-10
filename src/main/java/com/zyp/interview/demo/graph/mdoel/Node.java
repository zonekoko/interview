package com.zyp.interview.demo.graph.mdoel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/12/2 13:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private Integer value;

    private Integer in;

    private Integer out;

    private List<Node> nexts;

    private List<Edge> edges;

    public Node(int data) {
        this.value = data;
    }
}
