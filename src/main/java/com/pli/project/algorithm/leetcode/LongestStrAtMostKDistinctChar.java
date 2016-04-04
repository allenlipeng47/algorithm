package com.pli.project.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/4/4.
 * http://cherylintcode.blogspot.com/2015/07/longest-substring-with-at-most-k.html
 */
public class LongestStrAtMostKDistinctChar {

    public int longestStrKDistinct(String str, int k) {
        int[] rec = new int[256];
        int len = str.length(), ans = 0, num = 0;
        for (int left = 0, right = 0; right < len; right++) {
            char ch = str.charAt(right);
            if (rec[ch - 'a'] == 0) {
                num++;
            }
            rec[ch - 'a']++;
            while (num > k) {
                ch = str.charAt(left++);
                if (--rec[ch - 'a'] == 0) {
                    num--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
