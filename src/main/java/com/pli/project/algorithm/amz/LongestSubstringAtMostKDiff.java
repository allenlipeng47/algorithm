package com.pli.project.algorithm.amz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/20.
 */
public class LongestSubstringAtMostKDiff {

    public int getLongest(String str, int k) {
        int ans = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < str.length()) {
            char chRight = str.charAt(right), chLeft = str.charAt(left);
            if (!map.containsKey(chRight) && map.size() >= k) {
                int num = map.get(chLeft);
                if (num <= 1) {
                    map.remove(chLeft);
                }
                else {
                    map.put(chLeft, num -  1);
                }
                left++;
            }
            else {
                map.put(chRight, map.getOrDefault(chRight, 0) + 1);
                right++;
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

}
