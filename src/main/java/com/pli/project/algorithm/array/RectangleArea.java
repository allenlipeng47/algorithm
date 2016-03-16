package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/12/12.
 * https://leetcode.com/problems/rectangle-area/
 */
public class RectangleArea {

    // a section (x, y). x < y
    static class Section {
        int x;  // the min value
        int y;  // the max value
        public Section(int x, int y) {
            if (x < y) {
                this.x = x;
                this.y = y;
            }
            else {
                this.x = y;
                this.y = x;
            }
        }
    }

    // calculate length of intersection of two sections
    // for example, (1, 5), (2, 7) returns 3. (1, 6), (2, 4) returns 2.
    public static int getSec(Section p1, Section p2) {
        if (p1.x > p2.x) {
            Section tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        if (p2.x >= p1.y) {
            return 0;
        }
        if (p2.y <= p1.y) {
            return p2.y - p2.x;
        }
        else {
            return p1.y - p2.x;
        }
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Section h1 = new Section(A, C);
        Section h2 = new Section(E, G);
        Section v1 = new Section(B, D);
        Section v2 = new Section(F, H);
        return (h1.y - h1.x) * (v1.y - v1.x) + (h2.y - h2.x) * (v2.y - v2.x) - getSec(h1, h2) * getSec(v1, v2);
    }

    public static void main(String[] args) {
//        Section s1 = new Section(4, 5);
//        Section s2 = new Section(1, 2);
//        System.out.println(getSec(s1, s2));
        System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
    }

}