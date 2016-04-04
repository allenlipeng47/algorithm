package com.pli.project.algorithm.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/25.
 */
public class ScheduleCourseTest {

    ScheduleCourse s;

    @Before
    public void setUp() {
        s = new ScheduleCourse();
    }

    @Test
    public void test() {
        int[][] courses = {
                {4, 2},
                {4, 3},
                {3, 0},
                {3, 1}
        };
        assert s.canFinish(5, courses) == true;

        courses = new int[][]{
                {0, 1},
                {1, 0}
        };
        assert s.canFinish(2, courses) == false;

        courses = new int[][]{};
        assert s.canFinish(2, courses);
    }


}
