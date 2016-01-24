package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/24.
 */
public class ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target)
                    ans += right - (left++);
                else
                    right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }
}
