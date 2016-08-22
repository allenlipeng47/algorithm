package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/21.
 */
public class Sqrt {

    public double mySqrt(int x) {
        double left = 0, right = x;
        while (left < right) {
            double mid = left + (right - left) / 2;
            double pow = Math.pow(mid, 2);
            if (Math.abs(pow - x) < 0.1) {
                return mid;
            }
            else if (pow > x) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return 0;
    }

}
