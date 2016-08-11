package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/10.
 */
public class TrappingRainWater {

    public int trap2(int[] height) {
        int[] leftDp = new int[height.length], rightDp = new int[height.length];
        int leftMax = 0, rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftDp[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
            rightDp[height.length - i - 1] = rightMax;
            rightMax = Math.max(rightMax, height[height.length - i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int hi = Math.min(leftDp[i], rightDp[i]);
            ans += hi <= height[i] ? 0 : (hi - height[i]);
        }
        return ans;
    }

    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, max = 0, left = 0, right = height.length - 1;
        while (left <= right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                max += leftMax - height[left++];
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                max += rightMax - height[right--];
            }
        }
        return max;
    }

}
