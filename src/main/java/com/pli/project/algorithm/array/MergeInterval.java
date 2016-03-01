package com.pli.project.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lipeng on 2015/12/12.
 * Given an array of intervals, merge them to see how many individual intervals totally has
 */
public class MergeInterval {

    public static int leastRange(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans = 0;
        for (int i = 0; i < pairs.length;) {
            int right = pairs[i][1];
            for (i++; i < pairs.length && pairs[i][0] < right; i++) {
                right = Math.max(right, pairs[i][1]);
            }
            ans++;
        }
        return ans;
    }



    public static void main(String[] args) {
        int[][] arr = {
                {6, 8}, {1, 4}, {3, 7}, {2, 5}, {9, 10}
        };
        System.out.println(leastRange(arr));
    }


}
