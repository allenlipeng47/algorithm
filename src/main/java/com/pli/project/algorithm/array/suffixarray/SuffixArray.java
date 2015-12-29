package com.pli.project.algorithm.array.suffixarray;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by pli on 12/29/2015.
 */
public class SuffixArray {

    public String str;

    public Suffix[] suffices;

    public int[] lcp;

    public SuffixArray(String str) {
        init(str);
        Arrays.sort(suffices);
        buildLcp();
    }

    // mostly c is Collections.reverseOrder
    public SuffixArray(String str, Comparator c) {
        init(str);
        Arrays.sort(suffices, c);
        buildLcp();
    }

    public void init(String str) {
        this.str = str;
        suffices = new Suffix[str.length()];
        for(int i=0; i<suffices.length; i++)
            suffices[i] = new Suffix(str, i);
    }

    private void buildLcp() {
        lcp = new int[str.length()];
        for(int i=1; i<str.length(); i++) {
            int cp, N = Math.min(suffices[i-1].length(), suffices[i].length());
            for(cp=0; cp<N && suffices[i].charAt(cp)==suffices[i-1].charAt(cp); cp++);
            lcp[i] = cp;
        }
    }

    /*
        0   1   2   3   4   5
        a   a   a   b   n   n
            n   n   a   a   a
            a   a   n       n
                n   a       a
                a   n
                    a
        For string query, find mid where query>=arr[mid] && query<arr[mid+1]
     */
    public int rank(String query) {
        int lo = 0, hi = suffices.length-1;
        while (lo<hi) {
            int mid = (lo + hi)>>1;
            int cmp = compare(query, suffices[mid]);
            if(cmp<0)
                hi = mid - 1;
            else if(cmp>0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public static int compare(String query, Suffix suffix) {
        int N = Math.min(query.length(), suffix.length());
        for(int i=0; i<N; i++) {
            if(query.charAt(i) > suffix.charAt(i))
                return 1;
            if(query.charAt(i) < suffix.charAt(i))
                return -1;
        }
        return query.length() - suffix.length();
    }

    public static void main(String[] args) {
        SuffixArray arr = new SuffixArray("banana");
        System.out.println(arr.rank("n"));
        System.out.println();
    }
}
