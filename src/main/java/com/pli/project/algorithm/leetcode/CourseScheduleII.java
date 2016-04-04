package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by lipeng on 2016/3/24.
 * Practice for topological sorting
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(list, prerequisites, visited, i)) {
                    break;
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < numCourses && !list.isEmpty(); i++) {
            ans[i] = list.removeFirst();
        }
        return ans;
    }

    private boolean dfs(LinkedList<Integer> ans, int[][] prerequisites, int[] visited, int course) {
        if (visited[course] == 1) {
            ans.clear();
            return false;
        }
        visited[course] = 1;
        for (int[] pre1 : prerequisites) {
            if (pre1[1] != course || visited[pre1[0]] == 2) {
                continue;
            }

            if (!dfs(ans, prerequisites, visited, pre1[0])) {
                return false;
            }
        }
        visited[course] = 2;
        ans.addFirst(course);
        return true;
    }

    public static void main(String[] args) {
//        int[][] prerequisites = {
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2}
//        };
//        int[][] prerequisites = {
//                {1,0},
//                {1, 0}
//        };
//        int[][] prerequisites = {
//                {0, 1}
//        };
//        int[][] prerequisites = {
//                {0, 2},
//                {1, 2},
//                {2, 0},
//        };
//        int[][] prerequisites = {
//                {0, 1},
//                {1, 0}
//        };
        int[][] prerequisites = {
        };
        CourseScheduleII c = new CourseScheduleII();
        int[] ans = c.findOrder(2, prerequisites);
        System.out.println(Arrays.toString(ans));
    }



}
