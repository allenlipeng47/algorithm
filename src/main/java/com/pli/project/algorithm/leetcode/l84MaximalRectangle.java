package com.pli.project.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/8/7.
 * https://leetcode.com/problems/maximal-rectangle/
 * This is actually a variation of histogram. O(n^2) time, O(n) space.
 */
public class l84MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            }
            max = Math.max(max, getMaxHistogram(dp));
        }
        return max;
    }

    public static int getMaxHistogram(int[] arr) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int curr = stack.pop();
                int area = (stack.isEmpty() ? i : (i - stack.peek() - 1)) * arr[curr];
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            int area = (stack.isEmpty() ? arr.length : (arr.length - stack.peek() - 1)) * arr[curr];
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] chs = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(chs));
    }


}
