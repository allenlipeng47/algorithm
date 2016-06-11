package com.pli.project.lambda;

import com.pli.project.algorithm.array.IncreasingTriplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipeng on 2016/6/10.
 * Use lambda where Java defines interface functions
 */
public class Usage {

    public static void main(String[] args) {
        forEachCase();
        removeIf();
        replaceAll();
        sortCase1();
        sortCase2();
        threadCase();
    }

    public static void forEachCase() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(i -> System.out.println(i));
    }

    public static void removeIf() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeIf(i -> i == 2); // if only has one element, doesn't has to be (Integer i) -> i == 2 ....  Could be i -> i == 2
        System.out.println(list);
    }

    public static void replaceAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.replaceAll(i -> -i);
        System.out.println(list);
    }

    public static void sortCase1() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        Collections.sort(list, (i1, i2) -> i1 - i2);
        System.out.println(list);
    }

    public static void sortCase2() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.sort((i1, i2) -> i1 - i2);
        System.out.println(list);
    }

    public static void threadCase() {
        Runnable r1 = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {}
        };
        new Thread(r1).start();
    }

}
