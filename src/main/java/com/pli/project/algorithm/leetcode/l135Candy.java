package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/7/20.
 */
public class l135Candy {


    public static int candy(int[] ratings) {
        int pre = 1, countDown = 0, total = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;   // progression part
                    if (countDown >= pre) { // check if pre is tall enough
                        total += countDown - pre + 1;
                    }
                    pre = 1;    // when ascending and there is countDown, prev should be 1
                    countDown = 0;
                }
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;   // when equals to previous one, set to 1. Else set to prev + 1
                total += pre;
            }
            else {
                countDown++;
            }
        }
        if (countDown > 0) {    // check if there is countDown in the end
            total += countDown * (countDown + 1) / 2;
            if (countDown >= pre) {
                total += countDown - pre + 1;
            }
        }
        return total;
    }

    public static int candy2(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++)  {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i : candy) {
            ans += i;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] ratings = {2, 3, 2};
        System.out.println(candy2(ratings));
    }



}
