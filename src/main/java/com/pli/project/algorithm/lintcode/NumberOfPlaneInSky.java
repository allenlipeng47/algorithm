package com.pli.project.algorithm.lintcode;

import java.util.*;

/**
 * Created by lipeng on 2016/9/7.
 */
public class NumberOfPlaneInSky {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int countOfAirplanes(List<Interval> airplanes) {
        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        Collections.sort(airplanes, (a1, a2) -> a1.start - a2.start);
        for (Interval i : airplanes) {
            while (!queue.isEmpty() && i.start >= queue.peek()) {
                queue.poll();
            }
            queue.add(i.end);
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }


}
