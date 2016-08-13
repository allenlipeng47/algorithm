package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/12.
 */
public class FindKthLargestTest {

    @Test
    public void test1() {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {4, 5, 6, 1, 2, 3, 0};
        assert f.findKthLargest(nums, 1) == 6;
        assert f.findKthLargest(nums, 4) == 3;
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int lo = left, hi = right, pivot = nums[left];
            while (lo < hi) {
                while (lo < hi && pivot <= nums[hi]) {
                    hi--;
                }
                nums[lo] = nums[hi];
                while (lo < hi && pivot >= nums[lo]) {
                    lo++;
                }
                nums[hi] = nums[lo];
            }
            if (lo == nums.length - k) {
                return nums[lo];
            }
            else if (lo < nums.length - k) {
                right = lo - 1;
            }
            else {
                left = lo + 1;
            }
        }
        return -1;
    }

}
