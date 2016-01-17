package com.pli.project.algorithm.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lipeng on 2016/1/16.
 * https://leetcode.com/problems/find-median-from-data-stream/
 * http://www.allenlipeng47.com/blog/index.php/2015/02/01/find-the-median-in-an-array-by-using-heap/
 * Solution, use 2 heaps.
 */
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if(maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size() == 0)
            return minHeap.peek();
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
    }


    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
