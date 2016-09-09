package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/8.
 * https://leetcode.com/problems/bulls-and-cows/
 * https://discuss.leetcode.com/topic/28463/one-pass-java-solution
 */
public class l299BullCow {

    // secret makes num--, guess makes num++
    public static String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] num = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }
            if (num[secret.charAt(i) - '0']-- > 0) {
                cow++;
            }
            if (num[guess.charAt(i) - '0']++ < 0) {
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }

}
