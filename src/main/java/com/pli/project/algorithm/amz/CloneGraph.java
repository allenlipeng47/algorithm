package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (map.containsKey(node) || node == null) {
            return map.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        node.neighbors.forEach(p -> clone.neighbors.add(cloneGraph(p)));
        return clone;
    }

}
