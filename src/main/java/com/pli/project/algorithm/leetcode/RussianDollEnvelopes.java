package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/6/7.
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 What is the maximum number of envelopes can you Russian doll? (put one inside other)
 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {

    // graph solution, but it exceeds time limit. Should use longest increasing subsequent solution.
    public static int maxEnvelopes2(int[][] envelopes) {
        int len = envelopes.length;
        int[] inDegree = new int[len];
        HashMap<Integer, HashSet<Integer>> inBound = new HashMap<>();  // HashMap as graph
        HashMap<Integer, HashSet<Integer>> outBound = new HashMap<>();  // HashMap as graph
        for (int i = 0; i < len; i++) {
            inBound.put(i, new HashSet<>());
            outBound.put(i, new HashSet<Integer>());
        }
        // construct the graph
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // there is an arrow from i to j
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    inBound.get(j).add(i);
                    outBound.get(i).add(j);
                }
                else if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    inBound.get(i).add(j);
                    outBound.get(j).add(i);
                }
            }
        }
        int ans = 0;
        while (!outBound.isEmpty()) {
            List<Integer> delNode = new ArrayList<>();
            for (Map.Entry<Integer, HashSet<Integer>> entry : outBound.entrySet()) {
                if (entry.getValue().size() == 0) {
                    delNode.add(entry.getKey());
                }
            }
            for (int to : delNode) { // delete the edges going to i
                for (int from : inBound.get(to)) {
                    outBound.get(from).remove(to);
                }
                inBound.remove(to);
                outBound.remove(to);
            }
            ans++;
        }
        return ans;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {   // if width are same, then order in descending order of height
                    return o2[1] - o1[1];
                }
                else {
                    return o1[0] - o2[0];   // if width are different, order them normally
                }
            }
        });
        int[] rec = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int pos = Arrays.binarySearch(rec, 0, len, envelope[1]);
            // negative means didn't find the element. Then it points to first element which is greater than envelope[1]
            if (pos < 0) {
                pos = -pos - 1;
            }
            rec[pos] = envelope[1];
            if (pos == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = {
//                {4,5},{4,6},{6,7},{2,3},{1,1},{1,1}
                {1, 1}, {1, 2}, {2, 1}, {2, 2}
        };
        System.out.println(maxEnvelopes(envelopes));
    }

}
