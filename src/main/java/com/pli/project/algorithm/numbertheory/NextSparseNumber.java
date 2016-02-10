package com.pli.project.algorithm.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lipeng on 2016/2/9.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=391
 */
public class NextSparseNumber {

    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testNum = Integer.valueOf(br.readLine());
            for (int i = 0; i < testNum; i++) {
                int n = Integer.valueOf(br.readLine());
                System.out.println(nextSparseNumber(n));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static int nextSparseNumber(int n) {
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            if ((i & (i<<1)) == 0) {
                return i;
            }
        }
        return n;
    }

}
