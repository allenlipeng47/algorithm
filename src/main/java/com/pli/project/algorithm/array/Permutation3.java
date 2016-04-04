package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2016/01/19.
 * Given a array, array may consists of duplicate elements. Print all possible permutations
 * For example, num = [1, 2, 1], should return [1, 1, 2], [1, 2, 1], [2, 1, 1]
 * Solution. Original solution is from: https://leetcode.com/discuss/73856/really-easy-solution-easier-than-solutions-with-very-high-vote
 * We should set a a used[] array. When we use num[i], if num[i] == num[i - 1], we should check if we go on.
 * If num[i] == num[i - 1], and num[i - 1] is not used, then we shouldn't go on.
 */
public class Permutation3 {

    public static List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permutateHelper(nums, used, ans, new ArrayList<Integer>());
        return ans;
    }

    public static void permutateHelper(int[] nums, boolean[] used,  List<List<Integer>> ans, List<Integer> currRes) {
        if (currRes.size() == nums.length) {
            ans.add(new ArrayList<Integer>(currRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            used[i] = true;
            currRes.add(nums[i]);
            permutateHelper(nums, used, ans, currRes);
            currRes.remove(currRes.size() - 1);
            used[i] = false;
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        List<List<Integer>> list = permutate(nums);
        System.out.println(list);
    }

}



