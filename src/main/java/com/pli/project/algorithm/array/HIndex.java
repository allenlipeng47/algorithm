package com.pli.project.algorithm.array;


import java.util.Arrays;

/**
 * Created by lipeng on 2016/1/18.
 */
public class HIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int totalCitation = n - 1 - i + 1;
            if (citations[i] >= totalCitation)
                return totalCitation;
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {5, 5, 5};
        System.out.println(hIndex(citations));

    }
}
