package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/7/19.
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class SkyLine {

    public static List<int[]> getSkyline(int[][] buildings) {
        // 1. Build point elements
        List<int[]> points = new ArrayList<>();
        for (int[] build : buildings) {
            points.add(new int[]{build[0], build[2]});
            points.add(new int[]{build[1], -build[2]});
        }
        /** 2. sort the points according to x axis.
         If the input is [0, 2, 3], [2, 5, 3]. Then points will be [0, 3], [2, -3], [2, 3], [5, 0]. In this way, it will
         have result: [0, 3], [2, 0], [2, 3], [5, 0]
         Instead, we should sort like [0, 3], [2, 3], [2, -3], [5, 0]. In this way, it will output result [0, 3], [5, 0]
         **/
        points.sort((p1, p2) -> p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0]);
        // 3. Go through points and find the key point, using TreeMap and maxValue
        int max = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>(); // (key = Height, value = count)
        tm.put(0, 1);
        List<int[]> ans = new ArrayList<>();
        for (int[] point : points) {
            int height = point[1];
            int count = tm.getOrDefault(Math.abs(height), 0);
            if (height > 0) {
                tm.put(height, count + 1);
            }
            else if (count == 1){
                tm.remove(-height);
            }
            else {
                tm.put(-height, count - 1);
            }
            int newMax = tm.lastKey();
            if (max != newMax) {
                ans.add(new int[]{point[0], newMax});
                max = newMax;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {
//                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
                {0, 2, 3}, {2, 5, 3}
        };
        List<int[]> ans = getSkyline(points);
        ans.forEach(p -> System.out.println(Arrays.toString(p)));
    }
}
