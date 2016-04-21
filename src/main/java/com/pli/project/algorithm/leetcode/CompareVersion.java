package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/4/20.
 */
public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int num1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int num2 = j < v2.length ? Integer.valueOf(v2[j]) : 0;
            if (num1 == num2) {
                i++;
                j++;
                continue;
            }
            return num1 > num2 ? 1 : -1;
        }
       return 0;
    }

    public static void main(String[] args) {
        int result = compareVersion("1.0.0.2", "1.0");
        System.out.println(result);
//        String str = "132.123.123";
//        String[] strs = str.split("/.");
//        System.out.println(Arrays.toString(strs));
    }


}
