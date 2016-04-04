package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by lipeng on 2015/11/10.

 Given a unsorted array with n elements. How can we find the largest gap between consecutive numbers of sorted version in O(n)?
 For example, we have a unsorted array
 9 19 13 12 33 41 22
 the sorted version is
 9 12 13 19 22 33 41
 the output of the algorithm should be 33-22 = 11
 */
public class MaxGap {

    public static int getMaxGap(int[] arr) {
        if(arr==null || arr.length==1) {
            return -1;
        }
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            maxValue = arr[i]>maxValue ? arr[i] : maxValue;
            minValue = arr[i]<minValue ? arr[i] : minValue;
        }
        double distance = (double)(maxValue - minValue) / (double)(arr.length+1);   //arr.length+1 is the bucket size;
        HashSet<Integer>[] buckets = new HashSet[arr.length+1];
        for(int i=0; i<buckets.length; i++) {
            buckets[i] = new HashSet<Integer>();
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==maxValue) {  //bucketPos of max val is buckets.length, which is an exception.
                buckets[buckets.length-1].add(arr[i]);
            }
            else {
                int bucketPos = (int)((arr[i]-minValue) / distance);
                buckets[bucketPos].add(arr[i]);
            }
        }
        int gap = 1;
        for(int i=0; i<buckets.length; i++) {
            //every time, i starts from non-empty bucket. Find first empty bucket
            for(; i<buckets.length && buckets[i].size()!=0; i++);
            if(i>=buckets.length) {
                break;
            }
            int leftBucket = i-1;
            //from empty bucket, find the first non-empty bucket
            for(; i<buckets.length && buckets[i].size()==0; i++);
            if(i>=buckets.length) {
                break;
            }
            int rightBucket = i;
            // find the max val in left bucket and min val in right bucket.
            int preMax = Integer.MIN_VALUE;
            for(Integer num:buckets[leftBucket]) {
                preMax = num>preMax ? num : preMax;
            }
            int postMin = Integer.MAX_VALUE;
            for(Integer num:buckets[rightBucket]) {
                postMin = num<postMin ? num : postMin;
            }
            int currGap = postMin - preMax;
            currGap = postMin - preMax;
            gap = currGap>gap ? currGap : gap;
        }
        return gap;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 19, 13, 12, 33, 41, 22};
        int[] arr = {1, 2, 1, 1, 1, 1, 4, 2 };
        System.out.println(getMaxGap(arr));
    }

}
