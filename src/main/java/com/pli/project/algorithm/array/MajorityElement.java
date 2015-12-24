package com.pli.project.algorithm.array;

/**
 * Created by pli on 12/24/2015.
 * Find the majority element in an array.
 * element appears half or more than half times.
 */
public class MajorityElement {

    public static int findMajorityElement(int[] arr) {
        int result = arr[0], pre = arr[0], num = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]==result) {
                num++;
            }
            else {
                num--;
                if(num==0) {
                    pre = result;
                    result  = arr[i];
                    num = 1;
                }
            }
        }
        int numPre=0, numResult=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==pre) {
                numPre++;
            }
            else if(arr[i]==result) {
                numResult++;
            }
        }
//        System.out.println(result + " " + pre);
        if(numPre>=arr.length/2) {
//            System.out.println("result:" + pre);
            return pre;
        }
        else if(numResult>=arr.length/2) {
//            System.out.println("result:" + result);
            return result;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0};
        System.out.println(findMajorityElement(arr));
    }
}
