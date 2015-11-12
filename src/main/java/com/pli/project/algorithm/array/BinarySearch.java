package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/11/11.
 */
public class BinarySearch {

    /*
    For array 1, 2, 3, 4, 4, 4, 5, 5, 6. And given 4
    Should find the left-most position, where 4>=arr[pos]
    The answer should be 3. All [3, +) are equal or greater than 4
     */
    public static int getLeftOpen(int[] arr, int n) {
        if(arr==null||arr.length==0) {
            return -1;
        }
        if(arr[0]>=n) {
            return 0;
        }
        int left=1, right=arr.length-1, mid;
        while(left<=right) {
            mid = (left + right) / 2;
            if(arr[mid]<n) {    //try to move to right as far as possible
                left = mid + 1;
            }
            else if(arr[mid-1]<n) { //result check
                return mid;
            }
            else {  // means both arr[mid-1] and arr[mid] are at right side, should move to left
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
    For array 1, 2, 3, 4, 4, 4, 5, 5, 6. And given 4
    Should find the left-most position, where 4>arr[pos]
    The answer should be 6. all [5, +) are greater than 4
     */
    public static int getLeftClose(int[] arr, int n) {
        if(arr==null||arr.length==0) {
            return -1;
        }
        if(arr[0]>n) {
            return 0;
        }
        int left=1, right=arr.length-1, mid;
        while(left<=right) {
            mid = (left + right) / 2;
            if(arr[mid]<=n) {    //try to move to right as far as possible
                left = mid + 1;
            }
            else if(arr[mid-1]<=n) { //result check
                return mid;
            }
            else {  // means both arr[mid-1] and arr[mid] are at right side, should move to left
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 5, 6};
        int[] arr = {1, 2, 5, 7, 9, 10};
        System.out.println(getLeftClose(arr, 20));
    }

}
