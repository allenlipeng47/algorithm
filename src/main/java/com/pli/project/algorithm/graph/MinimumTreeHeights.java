package com.pli.project.algorithm.graph;

import java.util.*;

/**
 * Created by lipeng on 2016/1/5.
 * https://leetcode.com/problems/minimum-height-trees/
 * 1. Because tree node is 0, 1, 2, 3, 4 ... Consider constructing tree in ArrayList<HashSet<Integer>>
 * 2. Maintain a leave set, each time remove the leaves. Then update leave
 */
public class MinimumTreeHeights {

    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }
        int remaining = n;
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodes.get(i).size() == 1) {
                leaves.add(i);
            }
            else if (nodes.get(i).size() == 0) {
                remaining--;
            }
        }
        while (remaining > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = nodes.get(i).iterator().next();
                nodes.get(j).remove(i);
                if (nodes.get(j).size() == 1) {
                    newLeaves.add(j);
                }
                remaining--;
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Node> graph = getGraph(n, edges);
        while (n > 2) {
            HashSet<Integer> delNodes = new HashSet<Integer>();
            for(Node node : graph.values()) // put all leaf node to delNode
                if(node.neighbors.size() == 1)
                    delNodes.add(node.value);
            for(Node node : graph.values()) // if a node's neighbor has leaf node, then delete the leaf node
                for(int delNode : delNodes)
                    node.neighbors.remove(delNode);
            for(int delNode : delNodes) {   // remove the leaf node
                graph.remove(delNode);
                n--;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int node : graph.keySet())
            list.add(node);
        return list;
    }

    // convert edge graph to hashmap graph
    public static HashMap<Integer, Node> getGraph(int n, int[][] edges) {
        HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
        for(int[] edge : edges) {
            Node node = graph.get(edge[0]);
            if(node == null) {
                node = new Node(edge[0]);
                graph.put(edge[0], node);
            }
            node.neighbors.add(edge[1]);
            node = graph.get(edge[1]);
            if(node == null) {
                node = new Node(edge[1]);
                graph.put(edge[1], node);
            }
            node.neighbors.add(edge[0]);
        }
        return graph;
    }

    private static class Node {
        int value;
        HashSet<Integer> neighbors;

        public Node(int value) {
            neighbors = new HashSet<Integer>();
            this.value = value;
        }

        public void add(int neighbor) {
            neighbors.add(neighbor);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };
        int n = 6;
        System.out.println(findMinHeightTrees2(n, edges));


    }
}
