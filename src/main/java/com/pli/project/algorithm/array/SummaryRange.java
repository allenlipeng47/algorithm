package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pli on 12/21/2015.
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRange {

    public static List<String> summaryRanges(int[] nums) {
        int start = 0, end;
        List<String> ans = new ArrayList<String>();
        for (end = 0; end <= nums.length - 1; end++) {
            if (end == nums.length - 1 || nums[end] + 1 != nums[end + 1]) {
                if (start == end) {
                    ans.add(String.valueOf(nums[start]));
                }
                else {
                    ans.add(nums[start] + "->" + nums[end]);
                }
                start = end + 1;
            }
        } // for
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,7};
        System.out.println(summaryRanges(arr));
    }
}



