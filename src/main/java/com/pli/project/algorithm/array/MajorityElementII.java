package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/12/12.
 * https://leetcode.com/problems/majority-element-ii/
 * Find k majority elements, where each element size is greater than n / k.
 * If found, then element_num++
 * If not found
 *      If list still has space, then make a new one.
 *      If list is full, then each element in list--. If make it zero, then remove from list.
 */
public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        int size = nums.length / 3;
        List<Integer[]> list = new ArrayList<>();
        for (int i : nums) {
            boolean found = false;
            for (Integer[] ele : list) {
                if (ele[0] == i) {
                    ele[1]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (list.size() < 3) {
                    list.add(new Integer[] {i, 1});
                }
                else {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        if (--list.get(j)[1] <= 0) {
                            list.remove(j);
                        }
                    } // remove element
                } // else
            } // not found update.
        }
        for (Integer[] ele : list) {
            ele[1] = 0;
        }
        for (int i : nums) {
            for (Integer[] ele : list) {
                if (ele[0] == i) {
                    ele[1]++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer[] ele : list) {
            if (ele[1] >= size) {
                ans.add(ele[0]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        System.out.println(majorityElement(nums));
    }


}
