package com.pli.project.algorithm.amz;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/11.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {    // has duplicate, move left until there is no duplicate between [left, right]
                set.remove(s.charAt(left++));
            }
            else {
                set.add(s.charAt(right++)); // has no duplicate between [left, right], move right
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

}
