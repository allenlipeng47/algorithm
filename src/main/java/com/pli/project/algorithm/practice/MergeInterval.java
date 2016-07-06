package com.pli.project.algorithm.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lipeng on 2016/7/6.
 */
public class MergeInterval {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> mergeLambda(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        int i = 0, len = intervals.size();
        Collections.sort(intervals, (p1, p2) -> {return p1.start - p2.start;});
        while (i < len) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i++).end;
            while (i < len && intervals.get(i).start <= currEnd) {
                currEnd = Math.max(currEnd, intervals.get(i++).end);
            }
            ans.add(new Interval(currStart, currEnd));
        }
        return ans;
    }

    public static List<Interval> mergeLegacy(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        int i = 0, len = intervals.size();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        while (i < len) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i++).end;
            while (i < len && intervals.get(i).start <= currEnd) {
                currEnd = Math.max(currEnd, intervals.get(i++).end);
            }
            ans.add(new Interval(currStart, currEnd));
        }
        return ans;
    }

    public static void main(String[] args) {

    }

 }
