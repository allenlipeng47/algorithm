package com.pli.project.algorithm.stack;

import com.pli.project.algorithm.exercise2014.IntegerSet;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

/**
 * Created by lipeng on 2015/10/14.
 */
public class MaxHistogramArea {

    /*
    This method calculate how further can each element reach to left and right side.
     */
    public static int getMaxArea(int[] arr) {
        if(arr==null||arr.length<1) {
            return 0;
        }
        Stack<Integer> leftMostStack = new Stack<Integer>();
        Stack<Integer> rightMostStack = new Stack<Integer>();
        int[] leftMostTag = new int[arr.length];
        int[] rightMostTag = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!rightMostStack.isEmpty() && arr[arr.length-i-1]<=arr[rightMostStack.peek()]) {
                rightMostStack.pop();
            }
            if(rightMostStack.isEmpty()) {
                rightMostTag[arr.length-i-1] = i;
            }
            else {
                rightMostTag[arr.length-i-1] = rightMostStack.peek() - (arr.length-i);
            }
            rightMostStack.push(arr.length-i-1);
        }
        for(int i=0; i<arr.length; i++) {
            while(!leftMostStack.isEmpty() && arr[i]<=arr[leftMostStack.peek()]) {
                leftMostStack.pop();
            }
            if(leftMostStack.isEmpty()) {
                leftMostTag[i] = i;
            }
            else {
                leftMostTag[i] = i - leftMostStack.peek() - 1;
            }
            leftMostStack.push(i);
        }
        int maxSize = Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++) {
            int currSize = leftMostTag[i] + rightMostTag[i] + 1;
            currSize *= arr[i];
            maxSize = maxSize < currSize ? currSize : maxSize;
        }
        return maxSize;
    }

    public static int getMaxArea2(int[] arr) {
        if(arr==null||arr.length<1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxSize = 0;
        for(int i=0; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                int tp = stack.pop();
                int currSize = arr[tp] * (stack.isEmpty() ? i : i-stack.peek()-1);
                maxSize = Math.max(maxSize, currSize);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int tp = stack.pop();
            int currSize = arr[tp] * (stack.isEmpty() ? arr.length : arr.length-stack.peek()-1);
            maxSize = Math.max(maxSize, currSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 1};
//        int[] arr = {1, 2, 3, 4};
//        int[] arr = {4, 3, 2, 1};
//        int[] arr = {6, 2, 5, 4, 5, 1, 6};
//        int[] arr = {1, 4, 3, 2};
//        int[] arr = {6, 1, 2, 3, 5, 4};
//        int[] arr = {1, 1, 1};
//        int[] arr = {4, 5, 3, 2, 1};
//        int[] arr = {1};
//        int[] arr = {1, 3, 5, 4, 2, 6};
        int[] arr = {6, 2, 5, 4, 5, 6};
        System.out.println(getMaxArea2(arr));
    }

}
