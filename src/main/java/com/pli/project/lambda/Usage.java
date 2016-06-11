package com.pli.project.lambda;

import com.pli.project.algorithm.array.IncreasingTriplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipeng on 2016/6/10.
 * We use lambda where Java defines interface functions
 */
public class Usage {

    public static void main(String[] args) {
        forEachCase();
        sortCase();
    }

    public static void forEachCase() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach((Integer i) -> System.out.println(i));
    }

    public static void sortCase() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        Collections.sort(list, (Integer i1, Integer i2) -> i1 - i2);
        System.out.println(list);
    }

}
