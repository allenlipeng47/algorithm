package com.pli.project.algorithm.numbertheory;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by lipeng on 2015/11/21.
 * http://careercup.com/question?id=4816567298686976
 * Given a prime set, we call "prime expressible" if a number can be factorized only using given prime numbers. Find n-th big expressible number.

 E.g., prime set = {2, 3}
 expressible number = {1,2,3,4,6,8, 9, 12...}
 non-expressible number = {5, 10... }

 The primes in the prime set are ordered in an increasing order, and can include a prime < 10^4 (don't remember the exact range), and n can also be as large as 1-10^6.

 If we want to achieve O(nlogn), we shouldn't use heap. Because to search an element in heap, it takes O(n).
 Instead, we use treeset. Both search and insertion takes O(logn) time.
 */
public class NumberExpressible {

    public static int findNthExpressible(int[] arr, int n) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int ele:arr) {
            tree.add(ele);
        }
        int result = 0;
        for(int i=0; i<n; i++) {
            result = tree.pollFirst();
            for(int ele:arr) {
                tree.add(result*ele);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7};
        System.out.println(findNthExpressible(arr, 10));
    }

}
