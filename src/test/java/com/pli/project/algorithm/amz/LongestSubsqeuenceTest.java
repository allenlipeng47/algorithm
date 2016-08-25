package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.dp.LongestSubsequenceInString;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/24.
 */
public class LongestSubsqeuenceTest {

    @Test
    public void test1() {
        LongestSubsqeuence l = new LongestSubsqeuence();
        System.out.println(l.lengthOfLIS(new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
