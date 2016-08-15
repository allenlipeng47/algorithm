package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/8/14.
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Use ArrayList to maintain all elements. Use hashmap to maintain the position of each element.
 * When adding element, add into hashmap and arraylist.
 * When get random, return a random element in arraylist.
 * When remove, if removing element is not in the last element, should swap the removing element and last element.
 * In this way to keep arraylist continuous.
 */
public class RandomizedSet {

    Map<Integer, Integer> loc;
    List<Integer> list;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        loc = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (loc.containsKey(val)) {
            return false;
        }
        loc.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!loc.containsKey(val)) {
            return false;
        }
        int pos = loc.remove(val);
        int lastEle = list.remove(list.size() - 1);
        if (pos != list.size()) {
            list.set(pos, lastEle);
            loc.put(lastEle, pos);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
