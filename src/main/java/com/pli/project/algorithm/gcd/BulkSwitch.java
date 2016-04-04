package com.pli.project.algorithm.gcd;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/1/3.
 *
 */
public class BulkSwitch {

    public static int bulbSwitch(int n) {
        int ans = 0;
        for(int i = 1; i * i <= n; i++)
            ans++;
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(bulbSwitch(99999));
        System.out.println(bulbSwitch(4));
    }

}
