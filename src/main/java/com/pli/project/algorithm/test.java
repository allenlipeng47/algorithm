package com.pli.project.algorithm;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import com.pli.project.algorithm.util.TreeNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.IconInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lipeng on 2015/12/12.
 */
public class test {

    public static void main(String[] args) {
//        Character.getNumericValue()

    }


    public static int pow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans *= a;
            }
            b = b >> 1;
            a *= a;
        }
        return ans;
    }

    public static int gcd(int max, int min) {
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }

}