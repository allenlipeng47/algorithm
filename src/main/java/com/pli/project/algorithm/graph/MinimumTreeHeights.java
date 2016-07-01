package com.pli.project.algorithm.graph;

import java.util.*;

/**
 * Created by lipeng on 2016/1/5.
 * https://leetcode.com/problems/minimum-height-trees/
 * 1. Because tree node is 0, 1, 2, 3, 4 ... Consider constructing tree in ArrayList<HashSet<Integer>>
 * 2. Maintain a leave set, each time remove the leaves. Then update leave
 */
public class MinimumTreeHeights {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        // construct topology
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
        // initialize leaves
        for (int i = 0; i < n; i++) {
            if (nodes.get(i).size() == 1) {
                leaves.add(i);
            }
            else if (nodes.get(i).size() == 0) {
                remaining--;
            }
        }
        // at each while loop, remove the leave node. If operation node only has 1 node left, then it becomes leaf node too.
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

    public static void main(String[] args) {
        int[][] edges = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };
        int n = 6;
        System.out.println(findMinHeightTrees(n, edges));


    }
}
