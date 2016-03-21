package com.pli.project.algorithm.ms;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/20.
 */
public class MaxRectangle {

    public static int largestRectangleArea(int[] nums) {
        if (nums == null || nums.length <1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int tall = nums[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, tall * len);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int tall = nums[stack.pop()];
            int len = stack.isEmpty() ? nums.length : nums.length - stack.peek() - 1;
            max = Math.max(max, tall * len);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2};
        System.out.println(largestRectangleArea(nums));
    }
}
