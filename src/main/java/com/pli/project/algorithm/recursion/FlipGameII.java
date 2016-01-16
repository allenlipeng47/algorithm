package com.pli.project.algorithm.recursion;

import java.util.HashMap;

/**
 * Created by pli on 1/15/2016.
 */
public class FlipGameII {



    public static boolean canWin(String str) {
        HashMap<String, Boolean> result = new HashMap<String, Boolean>();
        return canWinHelper(str, result);
    }

    public static boolean canWinHelper(String str, HashMap<String, Boolean> hm) {
        if(hm.containsKey(str))
            return hm.get(str);
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.startsWith("++", i)) {
                String opponent = str.substring(0, i) + "--" + str.substring(i + 2, str.length());
                if(!canWinHelper(opponent, hm)) {
                    hm.put(str, true);
                    return true;
                }
            }
        }
        hm.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        String str = "++++++";
        System.out.println(canWin(str));
    }



}
