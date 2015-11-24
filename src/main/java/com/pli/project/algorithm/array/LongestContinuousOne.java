package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/11/19.
 */
public class LongestContinuousOne {

    public static int getLongestFlip1To0(int[] arr, int k) {
        int isValid = isValid(arr, k);
        if(isValid!=-1) {
            return isValid;
        }
        int tail = findNextZero(arr, 0);
        int head = tail;
        for(int i=0; i<k+1; i++) {
            head = findNextZero(arr, head);
        }
        int initTail = tail;
        int maxLen = 0;
        do {
            int currLen = ((head - 1 + arr.length) % arr.length - (tail + 1 + arr.length) % arr.length + arr.length + 1) % arr.length;
            maxLen = currLen > maxLen ? currLen : maxLen;
            head = findNextZero(arr, head);
            tail = findNextZero(arr, tail);
        } while(initTail != tail);
        return maxLen;
    }

    /*
    {0, 1, 1, 0, 0, 1, 1, 0}, pos=0, return 3
    {0, 1, 1, 0, 0, 1, 1, 0}, pos=1, return 3
    {0, 1, 1, 0, 0, 1, 1, 0}, pos=3, return 4
    {0, 1, 1, 0, 0, 1, 1, 0}, pos=7, return 0
     */
    public static int findNextZero(int[] arr, int pos) {
        for(int i=0; i<arr.length-1; i++) {
            pos = (pos + 1) % arr.length;
            if(arr[pos]==0) {
                return pos;
            }
        }
        return -1;
    }

    /*
    {0, 1, 1, 0, 0, 1, 1, 0}, k=3, then return arr.length-1
    {0, 1, 1, 0, 0, 1, 1, 0}, k=4, then return arr.length
    {0, 1, 1, 0, 0, 1, 1, 0}, k=1, then return -1. Means k is not a lot, we still needs to calculate.
     */
    public static int isValid(int[] arr, int k) {
        if(arr==null) {
            return -1;
        }
        int numOfZero = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) {
                numOfZero++;
            }
        }
        if(k==numOfZero-1) {
            return arr.length-1;
        }
        if(k>=numOfZero) {
            return arr.length;
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1};
        int[] arr = {0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0};
//        System.out.println(getLeftNum(arr, 0));
        System.out.println(getLongestFlip1To0(arr, 2));
    }

}
