package com.pli.project.algorithm.ms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipeng on 2016/3/17.
 * dfs to check if a graph has circle
 */
public class GraphExistCircle {

    public static boolean hasCircle(HashMap<Integer, HashSet<Integer>> graph) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (Integer i : graph.keySet()) {
            if (dfs(graph, i, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int i, HashMap<Integer, Integer> visited) {
        Integer status = visited.get(i);
        if (status == null) {
            visited.put(i, 0);
            HashSet<Integer> outgoing = graph.get(i);
            for (Integer node : outgoing) {
                if (dfs(graph, node, visited)) {
                    return true;
                }
            }
            visited.put(i, 1);
            return false;
        }
        else if (status == 1) {  // already visited.
            return false;
        }
        else{
            return true;    // is being visited. Has circle.
        }
    }


    public static void main(String[] args) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        HashSet<Integer> hs3 = new HashSet<>();
        HashSet<Integer> hs4 = new HashSet<>();
        hs1.add(2); hs1.add(3);
        hs2.add(4); hs3.add(4);
        hs4.add(1);
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        graph.put(1, hs1);
        graph.put(2, hs2);
        graph.put(3, hs3);
        graph.put(4, hs4);
        System.out.println(hasCircle(graph));

    }
}
