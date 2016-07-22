package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipeng on 2016/7/22.
 * DFS clone solution
 */
public class l133CloneGraph {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<>());
    }

    private static UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> hm) {
        if (node == null) {
            return null;
        }
        if (hm.containsKey(node.label)) {
            return hm.get(node.label);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        hm.put(cloneNode.label, cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor, hm));
        }
        return cloneNode;
    }


 }
