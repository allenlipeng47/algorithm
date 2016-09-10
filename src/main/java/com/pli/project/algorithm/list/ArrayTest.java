package com.pli.project.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/9/9.
 */
public class ArrayTest {

    public static void test1() {
        boolean[] b = new boolean[10];
        List<Boolean> list = Arrays.asList(b); // wrong, Arrays.asList doesn't accept primitive array
    }

    public static void test2() {
        Boolean[] b = new Boolean[10];
        List<Boolean> list1 = Arrays.asList(b); // correct
        List<Boolean> list2 = Arrays.asList(true, true, true);  // correct
    }

    public static void test3() {
        Boolean[] b = new Boolean[10];
        List<Boolean> list = Arrays.asList(b);
        list.add(true); // exception, Arrays.asList doesn't support add element.
        System.out.println(list);
    }

    public static void test4() {
        Boolean[] b1 = new Boolean[10];
        List<Boolean> list = new ArrayList<>(Arrays.asList(b1));
        list.add(true); // exception, Arrays.asList doesn't support add element.
        System.out.println(list);
    }

}
