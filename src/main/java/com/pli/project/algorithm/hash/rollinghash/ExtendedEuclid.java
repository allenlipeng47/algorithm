package com.pli.project.algorithm.hash.rollinghash;

/**
 * Created by lipeng on 2015/5/16.
 */
public class ExtendedEuclid {
    //  return array [d, a, b] such that d = gcd(p, q), ap + bq = d
    static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[] { p, 1, 0 };

        int[] vals = gcd(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[] { d, a, b };
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int vals[] = gcd(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + vals[0]);
        System.out.println(vals[1] + "(" + p + ") + " + vals[2] + "(" + q + ") = " + vals[0]);
    }
}
