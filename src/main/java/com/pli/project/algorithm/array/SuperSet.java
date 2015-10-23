package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/5/15.
 */
public class SuperSet {
    public static void main(String[] args) {
        char[] chs = {'a', 'b', 'c', 'd'};
//        printSuperSet(chs);
        List<List<Character>> result = getSuperSet(chs);
        System.out.println(result);
    }

    public static List<List<Character>> getSuperSet(char[] chs) {
        List<List<Character>> result = new ArrayList<List<Character>>();
        getSuperSetUtil(chs, 0, result, new ArrayList<Character>());
        return result;
    }

    public static void getSuperSetUtil(char[] chs, int start, List<List<Character>> result, List<Character> currResult) {
        if(start==chs.length) {
            ArrayList<Character> curr = new ArrayList<Character>(currResult);
            result.add(curr);
        }
        else {
            //count current char
            currResult.add(chs[start]);
            getSuperSetUtil(chs, start + 1, result, currResult);
            currResult.remove(currResult.size()-1);
            //doesn't count current char
            getSuperSetUtil(chs, start+1, result, currResult);
        }
    }

    public static void printSuperSet(char[] chs) {
        List<List<Character>> sets = new ArrayList<List<Character>>();
        int size = (int)Math.pow(2, chs.length);
        for(int i=0; i<size; i++) {
            List<Character> list = new ArrayList<Character>();
            for(int j=0; j<chs.length; j++) {
                if(((1<<j)&i)>0) {
                    list.add(chs[j]);
                }
            }
            sets.add(list);
        }
        System.out.println(sets);
    }

}