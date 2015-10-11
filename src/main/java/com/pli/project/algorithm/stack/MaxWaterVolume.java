package com.pli.project.algorithm.stack;

import java.util.Stack;

/**
 * Created by lipeng on 2015/10/11.
 */
public class MaxWaterVolume {

    public static int getMaxWater(int[] arr) {
        if(arr==null||arr.length<3) {
            return 0;
        }
        Stack<Integer> rightMaxStack = new Stack();
        Stack<Integer> leftMaxStack = new Stack();
        for(int i=0; i<arr.length; i++) {
            Integer rightTop;
            while(!rightMaxStack.isEmpty() && arr[rightMaxStack.peek()]<arr[i]) {
                rightMaxStack.pop();
            }
            rightMaxStack.push(i);
            Integer leftTop;
            while(!leftMaxStack.isEmpty() && arr[leftMaxStack.peek()]<arr[arr.length-1-i]) {
                leftMaxStack.pop();
            }
            leftMaxStack.push(arr.length - 1 - i);
        }
        int maxVolumne = 0;
        for(int i=0, right=0, left=0; i<arr.length; i++) {
            int rightMax = 0;
            if(i<rightMaxStack.get(right)) {
                rightMax = arr[rightMaxStack.get(right)];
            }
            else {  // then should be i==rightMaxStack.get(right)
                right++;
            }
            int leftMax = 0;
            if(left>=leftMaxStack.size()) {
                leftMax = arr[leftMaxStack.get(0)];
            }
            else if(i<leftMaxStack.get(leftMaxStack.size()-1-left)) {
                leftMax = arr[leftMaxStack.get(leftMaxStack.size()-left)];
            }
            else {
                left++;
            }
            if(rightMax==0 || leftMax==0) {
                continue;
            }
            else {
                maxVolumne += Math.min(leftMax, rightMax) - arr[i];
            }
        }
        return maxVolumne;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 6, 3, 4, 5, 7, 5, 4, 3, 6, 5, 4, 3};
//        int arr[] = {1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(getMaxWater(arr));
    }

}
