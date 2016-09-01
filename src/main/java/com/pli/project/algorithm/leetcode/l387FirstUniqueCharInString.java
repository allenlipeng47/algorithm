package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 * During the first time scan,
 * 1. Count the frequency of each char.
 * 2. Store the position of each char where it is firstly visited
 * In the second time, just scan the 26 times to find the lowest position iwhere the count is 1.
 */
public class l387FirstUniqueCharInString {

    public int firstUniqChar(String s) {
        int[] firstTime = new int[26], count = new int[26];
        for (int i = 0; i < s.length(); i++) {  // one time loop save the count of each char, and position of first visit.
            char ch = s.charAt(i);
            if (++count[ch - 'a'] == 1) {
                firstTime[ch - 'a'] = i;
            }
        }
        int ans = -1;
        for (int i = 0; i < firstTime.length; i++) {    // for elements which only show 1 time, get the smallest position.
            ans = (count[i] == 1 && firstTime[i] < ans) ? firstTime[i] : ans;
        }
        return ans;
    }

}
