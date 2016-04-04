package com.pli.project.algorithm.gcd;

import java.math.BigInteger;

/**
 * Created by lipeng on 2015/5/23.
 */
public class Gcd {

    /**
     * Keep a is the max val.
     * gcd{a,b}=gcd{?a,b}=gcd{a,?b}=gcd{?a,?b}
     * https://proofwiki.org/wiki/GCD_for_Negative_Integers
     */
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(b > a){
            int tmp = b; b = a; a = tmp;
        }
        if(b==0){
            return a;
        }
        int remainder = 0;
        do {
            remainder = a - b;
            a = b;
            b = remainder;
        } while(remainder!=0);
        return a;
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("-1");
        BigInteger b = new BigInteger("5");
        System.out.println(a.gcd(b));
        System.out.println(gcd(-1, 5));
        System.out.println(Math.sqrt(343));
    }

}
