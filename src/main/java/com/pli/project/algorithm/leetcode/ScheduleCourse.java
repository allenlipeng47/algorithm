package com.pli.project.algorithm.leetcode;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/3/25.
 */
public class ScheduleCourse {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prerequisites, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, int[][] prerequisites, int[] visited) {
        if (visited[course] == 1) { // is visiting, there is circle. return false.
            return false;
        }
        else if (visited[course] == 2) {    // visited before. quit.
            return true;
        }
        visited[course] = 1;
        for (int[] c : prerequisites) {
            if (c[1] == course && !dfs(c[0], prerequisites, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }


}
