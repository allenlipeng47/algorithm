package com.pli.project.algorithm.array;

import sun.rmi.server.InactiveGroupException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lipeng on 2016/1/17.
 * https://leetcode.com/problems/bulls-and-cows/
 For example:

 Secret number:  "1807"
 Friend's guess: "7810"
 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

 Please note that both secret number and friend's guess may contain duplicate digits, for example:

 Secret number:  "1123"
 Friend's guess: "0111"
 In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 */
public class BullAndCow {

    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>(),
                hm2 = new HashMap<Character, Integer>();
        int bull = 0, cow = 0;
        // 1st for loop calculates bull and build the hashmap for 2 string
        for(int i = 0 ; i < secret.length(); i++) {
            char sCh = secret.charAt(i), gCh = guess.charAt(i);
            if(sCh == gCh)
                bull++;
            else {
                Integer num = hm1.get(sCh);
                if(num == null)
                    hm1.put(sCh, 1);
                else
                    hm1.put(sCh, num + 1);
                num = hm2.get(gCh);
                if(num == null)
                    hm2.put(gCh, 1);
                else
                    hm2.put(gCh, num + 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : hm1.entrySet()) {
            Integer num = hm2.get(entry.getKey());
            if (num != null)
                cow += Math.min(entry.getValue(), num);
        }
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }

    public static void main(String[] args) {
//        String secret = "1807";
//        String guess = "7810";
//        String secret = "1123";
//        String guess = "0111";
        String secret = "1122";
        String guess = "2211";
        System.out.println(getHint(secret, guess));
    }


}
