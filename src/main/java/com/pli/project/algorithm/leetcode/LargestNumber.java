package com.pli.project.algorithm.leetcode;

import javafx.beans.binding.ObjectExpression;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by lipeng on 2016/4/14.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        Integer[] numss = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numss[i] = nums[i];
        }
        Arrays.sort(numss, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1) + String.valueOf(o2);
                String str2 = String.valueOf(o2) + String.valueOf(o1);
                return str1.compareTo(str2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int n : numss) {
            sb.insert(0, String.valueOf(n));
        }
        while (sb.charAt(0) =='0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] nums = {3, 30, 34, 5, 9};
//        int[] nums = {121, 12};
        int[] nums = {0, 00};
        LargestNumber largestNumber = new LargestNumber();
        String ans = largestNumber.largestNumber(nums);
        System.out.println(ans);
    }


}
