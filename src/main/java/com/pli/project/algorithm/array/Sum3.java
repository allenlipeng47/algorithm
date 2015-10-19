package com.pli.project.algorithm.array;

import java.util.*;

/**
 * Created by lipeng on 2015/10/17.
 * https://leetcode.com/problems/3sum/
 */
public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int[] sets = new int[3];
        HashSet<Element> hs = new HashSet<Element>();
        threeSum(nums, sets, 0, 0, hs);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(Element elem:hs) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(elem.sets[0]); list.add(elem.sets[1]); list.add(elem.sets[2]);
            res.add(list);
        }
        return res;
    }

    public static void threeSum(int[] nums, int[] sets, int numId, int setId, HashSet<Element> hs) {
        if(setId==3) {
            if(sets[0]+sets[1]+sets[2]==0) {
                Arrays.sort(sets);
                hs.add(new Element(sets));
            }
            return;
        }
        for(int i=numId; i<nums.length; i++) {
            sets[setId] = nums[i];
            threeSum(nums, sets, i+1, setId+1, hs);
            sets[setId] = 0;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);
    }

    static class Element {
        int[] sets = new int[3];

        public Element(int[] arr) {
            sets[0] = arr[0];
            sets[1] = arr[1];
            sets[2] = arr[2];
        }

        public int hashCode() {
            int prime = 31;
            int result = 1;
            result = prime * result + sets[0];
            result = prime * result + sets[1];
            result = prime * result + sets[2];
            return result;
        }

        public boolean equals(Object obj) {
            if(obj==null) {
                return false;
            }
            else if(obj==this) {
                return true;
            }
            else if(obj instanceof Element) {
                Element elem = (Element) obj;
                return elem.sets[0]==this.sets[0] && elem.sets[1]==this.sets[1] && elem.sets[2]==this.sets[2];
            }
            else {
                return false;
            }
        }

    }

}
