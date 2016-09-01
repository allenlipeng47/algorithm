package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class l374GuessNumber {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int reply = guess(mid);
            if (reply == 0) {
                return mid;
            }
            else if (reply < 0) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int guess(int mid) {
        return 1;
    }
}
