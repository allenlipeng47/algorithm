package com.pli.project.algorithm;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import com.pli.project.algorithm.util.TreeNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.IconInfo;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by lipeng on 2015/12/12.
 */
public class test {

    private static BigInteger factorial(int n) {
        BigInteger ans = new BigInteger("1");
        while (n > 1) {
            ans = ans.multiply(new BigInteger(String.valueOf(n--)));
        }
        return ans;
    }

    private static int numberOfFactor5(int n) {
        return n <= 0 ? 0 : n / 5 + numberOfFactor5(n / 5);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(numberOfFactor5(25));
    }


}