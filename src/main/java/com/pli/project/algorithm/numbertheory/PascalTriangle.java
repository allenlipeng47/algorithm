package com.pli.project.algorithm.numbertheory;

import com.pli.project.algorithm.exercise2014.IntegerSet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by lipeng on 2016/1/6.
 */
public class PascalTriangle {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0)
            return list;
        for(int m = 1; m < rowIndex + 1; m++) {
            long pre = list.get(list.size() - 1);
            long curr = pre * (rowIndex - m + 1) / m;
            list.add((int)curr);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = getRow(30);
        System.out.println(list);
    }

}
