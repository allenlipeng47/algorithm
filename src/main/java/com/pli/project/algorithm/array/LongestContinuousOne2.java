package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/11/19.
 */
public class LongestContinuousOne2 {

    public static int getLongestContinuous1(String s, int maxFlips) {
        int p1=0, p2=0, len = s.length(), num0=0, max=0;
        while(p2<len){
            //keep on growing the sliding window
            if(s.charAt(p2) == '0'){
                num0++;
            }

            if(num0 > maxFlips){
                while(s.charAt(p1)=='1')
                    p1++;
                p1++; num0--;
            }

            p2++;
            max = Math.max(max, p2-p1);
        }
        return max;
    }


    public static void main(String[] args) {
        String str = "011010101";
        System.out.println(getLongestContinuous1(str, 1));

    }

}
