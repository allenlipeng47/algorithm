package com.pli.project.algorithm.array;

import org.apache.commons.lang.ArrayUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by lipeng on 2015/11/30.
 * http://www.careercup.com/question?id=5631950045839360
 * write a method that takes in 2 int arrays of any size and returns an array that calculates the sum of both.
 for example, [1,2,3] and [2,3,4] will return [3,5,7]
 Or [1,2,3] and [2,3,5,5] will return [2,4,7,8]
 however, if it's like [9,9,2] and [0,1,3] you need to carry the sum so it returns as [1,0,0,5]
 */
public class BigNumberAdd {

    public static int[] add(int[] arr1, int[] arr2) {
        assert(arr1!=null && arr2!=null && arr1.length>0 && arr2.length>0);
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int carrier = 0;
        for(int i=arr1.length-1, j=arr2.length-1; i>=0||j>=0; i--, j--) {
            int curr = carrier;
            if(i>=0)
                curr += arr1[i];
            if(j>=0)
                curr += arr2[j];
            carrier = curr / 10;
            queue.addFirst(curr - carrier*10);
        }
        if(carrier>0)
            queue.addFirst(carrier);
        return ArrayUtils.toPrimitive((Integer[])queue.toArray(new Integer[queue.size()]));
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9, 2};
        int[] arr2 =    {9, 9, 3};
        int[] result = add(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
