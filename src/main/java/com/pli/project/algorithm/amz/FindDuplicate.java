package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/17.
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int fast = nums.length, slow = nums.length;
        do {
            fast = nums[nums[fast - 1] - 1];
            slow = nums[slow - 1];
        } while (fast != slow);
        slow = nums.length;
        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }


}
