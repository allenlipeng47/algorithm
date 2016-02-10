package com.pli.project.algorithm.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by lipeng on 2016/2/9.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=389
 */
public class JumpingNumber {

    public static void jumpingNumber(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for (int i = 1; i < 10 && i < n; i++) {
            jumpingNumber(ans, n, i);
        }
        for (int i : ans) {
            System.out.printf(i + " ");
        }
    }

    public static void jumpingNumber(ArrayList<Integer> ans, int max, int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(n);
        while (!list.isEmpty()) {
            int ele = list.pollFirst();
            if (ele > max) {
                continue;
            }
            ans.add(ele);
            int lastDigit = ele % 10;
            if (lastDigit > 0) {
                list.addLast(ele *10 + lastDigit - 1);
            }
            if (lastDigit < 9) {
                list.addLast(ele * 10 + lastDigit + 1);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testNum = Integer.valueOf(br.readLine());
            for (int i = 0; i < testNum; i++) {
                int n = Integer.valueOf(br.readLine());
                jumpingNumber(n);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
