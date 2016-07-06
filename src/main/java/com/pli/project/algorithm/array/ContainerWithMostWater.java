package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/7/5.
 * https://leetcode.com/problems/container-with-most-water/
 * The solution is to calculate the area size of left and right pillar. Then left or right depending on which pillar is shorter.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int currArea = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(max, currArea);
            if (height[left] < height[right]) { // move the shorter pillar inside
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }

}
