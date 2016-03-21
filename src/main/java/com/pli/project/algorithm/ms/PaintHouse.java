package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/20.
 */
public class PaintHouse {

    public static int getPaintCost(int[][] cost) {
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < cost.length; i++) {
            int rr = 0, gg = 0, bb = 0;
            rr = cost[i][0] + Math.min(b, g);
            gg = cost[i][1] + Math.min(r, b);
            bb = cost[i][2] + Math.min(r, g);
            r = rr;
            b = bb;
            g = gg;
        }
        return Math.min(Math.min(r, g), b);
    }

    public static void main(String[] args) {
        int[][] cost = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 2, 2},
                {2, 2, 1}
        };
        System.out.println(getPaintCost(cost));
    }
}
