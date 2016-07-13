package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipeng on 2016/7/11.
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnLine {

    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }


    public static int maxPoints(Point[] points) {
        HashMap<String, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int overlap = 0, max = 0;
            hm.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x, y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                // fix the sign issue. (3, -1) and (-3, 1) should be in same line. (0, -1) and (0, 1) should be in same line.
                if (x < 0 || (x == 0 && y < 0)) {
                    x = -x;
                    y = -y;
                }
                String key = String.valueOf(x) + String.valueOf(y);
                int value = hm.getOrDefault(key, 0);
                hm.put(key, value + 1);
                max = Math.max(max, value + 1);
            }
            ans = Math.max(ans, max + overlap + 1);
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return Math.abs(a);
    }

    // This gcd code got very lucky!!!
    // (6, -3) and (-6, 3) should be in same line. By this gcd, it can make (6, -3) / gcd(6, -3) == (-6, 3) / gcd(-6, 3)
    public static int gcd2(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(84, 250), new Point(0, 0), new Point(1, 0), new Point(0, -70), new Point(0, -70), new Point(1, -1),
        new Point(21, 10), new Point(42, 90), new Point(-42, -230)};
        System.out.println(maxPoints(points));
        System.out.println(gcd(-1, -1));
    }

}
