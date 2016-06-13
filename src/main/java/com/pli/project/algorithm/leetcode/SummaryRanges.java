package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.array.SummaryRange;

import java.util.*;

/**
 * Created by lipeng on 2016/6/12.
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 */
public class SummaryRanges {

    TreeMap<Integer, Interval> tm;

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tm = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tm.containsKey(val)) {  // to eliminate exception2
            return;
        }
        Map.Entry<Integer, Interval> lo = tm.lowerEntry(val), hi = tm.higherEntry(val);
        if (lo != null && lo.getValue().end + 1 == val && hi != null && val + 1 == hi.getValue().start) {   // in the meddle
            lo.getValue().end = hi.getValue().end;
            tm.remove(hi.getKey());
        }
        else if (lo != null && val <= lo.getValue().end + 1) {  // add to right or eliminate exception1
            lo.getValue().end = Math.max(val + 1, lo.getValue().end);
        }
        else if (hi != null && val + 1 == hi.getValue().start) {    // add to left
            Interval interval = new Interval(hi.getValue().start - 1, hi.getValue().end);
            tm.put(val, interval);
            tm.remove(hi.getKey());
        }
        else {
            tm.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tm.values());
    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(6);
        s.addNum(6);
        s.addNum(0);
        s.addNum(4);
        System.out.println(s.getIntervals());
        s.addNum(8);
        System.out.println(s.getIntervals());
        s.addNum(7);
        System.out.println(s.getIntervals());
        s.addNum(6);
        System.out.println(s.getIntervals());
    }

}
