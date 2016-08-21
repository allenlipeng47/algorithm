package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/21.
 */
public class ReconstructIteneraryTest {

    @Test
    public void test1() {
        String[][] tickets1 = {
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        };
        ReconstructItenerary r = new ReconstructItenerary();
        System.out.println(r.findItinerary(tickets1));

        String[][] tickets2 = {
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        };
        System.out.println(r.findItinerary(tickets2));
    }


}
