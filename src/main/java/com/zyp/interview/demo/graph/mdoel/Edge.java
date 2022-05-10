package com.zyp.interview.demo.graph.mdoel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/12/2 13:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    private Integer weight;

    private Node from;

    private Node to;
}
