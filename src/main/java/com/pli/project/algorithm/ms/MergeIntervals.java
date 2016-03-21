package com.pli.project.algorithm.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lipeng on 2016/3/19.
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int i = 0;
        List<Interval> ans = new ArrayList<>();
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            int start = curr.start, end = curr.end;
            i++;
            while (i < intervals.size()) {
                curr = intervals.get(i);
                if (curr.start > end) {
                    break;
                }
                end = Math.max(curr.end, end);
                i++;
            }
            ans.add(new Interval(start, end));
        }
        return ans;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(8, 10);
        Interval i2 = new Interval(15, 18);
        Interval i3 = new Interval(1, 3);
        Interval i4 = new Interval(2, 6);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        List<Interval> ans = merge(list);
        System.out.println(ans);
    }

}
