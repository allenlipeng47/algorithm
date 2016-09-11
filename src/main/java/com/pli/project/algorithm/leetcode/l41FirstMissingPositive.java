package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/11.
 * https://leetcode.com/problems/first-missing-positive/
 * https://discuss.leetcode.com/topic/10351/o-1-space-java-solution
 * Try best to put array like [1, 2, 3, 4, 5]. Last position we can put is the length of array.
 */
public class l41FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            // A[i] < 1, A[i] > len, eliminate the invalid value.
            // A[i] == i + 1 is valid, so pass
            // A[i] - 1 and i position has same value. This is the case [1, 1]
            if (A[i] < 1 || A[i] > A.length || A[i] == i + 1 || A[A[i] - 1] == A[i]) {
                i++;
            }
            else {
                swap(A, A[i] - 1, i);
            }
        }
        for (i = 0; i < A.length && A[i] == i + 1; i++);
        return i + 1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 2};
//        System.out.println(firstMissingPositive(nums));
    }
}
