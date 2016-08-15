package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/8/14.
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * Same as RandomizedSet problem. Add this one should use hashset to maintain the positions.
 */
public class RandomizedCollection {

    Map<Integer, Set<Integer>> loc;
    List<Integer> list;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        loc = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = loc.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        loc.put(val, set);
        list.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!loc.containsKey(val)) {
            return false;
        }
        Set<Integer> set = loc.get(val);
        int pos = set.iterator().next();
        set.remove(pos);    // remove loc
        if (set.isEmpty()) {
            loc.remove(val);
        }
        int lastEle = list.remove(list.size() - 1); // remove list
        if (pos != list.size()) {   // update list and loc
            list.set(pos, lastEle);     // update loc
            Set<Integer> lastEleSet = loc.get(lastEle);
            lastEleSet.remove(list.size()); // update list
            lastEleSet.add(pos);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
