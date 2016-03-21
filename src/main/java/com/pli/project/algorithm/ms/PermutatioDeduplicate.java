package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.exercise2014.IntegerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/3/17.
 */
public class PermutatioDeduplicate {

    public static List<List<Integer>> permutate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        permutateHelper(nums, ans, new ArrayList<Integer>(), new boolean[nums.length]);
        return ans;
    }

    public static void permutateHelper(int[] nums, List<List<Integer>> ans, ArrayList<Integer> curr, boolean[] visited) {
        if (curr.size() >= nums.length) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i >= 1 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            visited[i] = true;
            curr.add(nums[i]);
            permutateHelper(nums, ans, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2};
        List<List<Integer>> ans = permutate(nums);
        System.out.println(ans);
    }
}
