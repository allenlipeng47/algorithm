package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by lipeng on 2016/1/22.
 * http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 */
public class NumberOfAirplane {

    public static class Interval{
        int start, end;
        Interval( int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        for (Interval interval : airplanes) {
            Integer value = tree.get(interval.start);
            if (value == null) {
                tree.put(interval.start, 1);
            }
            else {
                tree.put(interval.start, value + 1);
            }
            value = tree.get(interval.end);
            if (value == null) {
                tree.put(interval.end, -1);
            }
            else {
                tree.put(interval.end, value - 1);
            }
        }
        int left = 0;
        int ans = 0;
        for (Integer parenthesis : tree.values()) {
            ans = Math.max(ans, left += parenthesis);
        }
        return ans;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 10);
        Interval i2 = new Interval(2, 3);
        Interval i3 = new Interval(5, 8);
        Interval i4 = new Interval(4, 7);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        System.out.println(countOfAirplanes(intervals));
    }

}
