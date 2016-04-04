package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/17.
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    /*
    public static int firstBadVersion(int n) {
        if (isBadVersion(0))
            return 0;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1))
                    return mid;
                else
                    right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return -1;
    } */
}
