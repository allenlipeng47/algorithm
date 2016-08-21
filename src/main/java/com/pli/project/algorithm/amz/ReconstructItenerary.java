package com.pli.project.algorithm.amz;

import java.util.*;

/**
 * Created by lipeng on 2016/8/21.
 * https://leetcode.com/problems/reconstruct-itinerary/Reconstruct Itinerary.
 * Should use PriorityQueue to build the lexical order neighbors.
 * Then dfs the initial point.
 * Because euler path exist, we just simply dfs each neighbor.
 */
public class ReconstructItenerary {

    private Deque<String> itenerary;
    private Map<String, Queue<String>> graph;

    public List<String> findItinerary(String[][] tickets) {
        itenerary = new ArrayDeque<>();
        graph = new HashMap();
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return new ArrayList<>(itenerary);
    }

    private void dfs(String arrival) {
        Queue<String> dests = graph.get(arrival);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());
        }
        itenerary.addFirst(arrival);
    }


}
