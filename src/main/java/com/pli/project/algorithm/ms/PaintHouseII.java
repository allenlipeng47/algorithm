package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/20.
 */
public class PaintHouseII {

    public static int getPaintCost(int[][] cost) {
        int min1 = 0, min2 = 0, id = -1;
        for (int i = 0; i < cost.length; i++) {
            int last1 = min1, last2 = min2, lastId = id;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            id = -1;
            for (int j = 0; j < cost[0].length; j++) {
                int c = cost[i][j] + (j == lastId ? last2 : last1);
                if (c < min1) {
                    min2 = min1;
                    min1 = c;
                    id = j;
                }
                else if (c < min2) {
                    min2 = c;
                } // if
            } // for
        }
        return min1;
    }

    public static void main(String[] args) {
        int[][] cost = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 1, 2, 2},
                {2, 2, 1, 1}
        };
        System.out.println(getPaintCost(cost));
    }
}
