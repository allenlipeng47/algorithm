package com.pli.project.algorithm.other;

import java.util.HashSet;

/**
 * Created by lipeng on 2015/12/12.
 */
public class HashSetTest {

    static class Point {
        int a;
        public Point(int a) {
            this.a = a;
        }
        public int hashCode() {
            return a;
        }
    }

    public static void test1() {
        Point element = new Point(1);
        HashSet<Point> hs = new HashSet<Point>();
        hs.add(element);
        element.a = 2;
        System.out.println(hs.contains(element));
    }

    public static void test2() {
        HashSet<Integer> element = new HashSet<Integer>();
        HashSet<HashSet<Integer>> hs = new HashSet<HashSet<Integer>>();
        hs.add(element);
        element.add(2);
        System.out.println(hs.contains(element));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
