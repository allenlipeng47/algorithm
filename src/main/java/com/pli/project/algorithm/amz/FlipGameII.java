package com.pli.project.algorithm.amz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/22.
 */
public class FlipGameII {

    public boolean canWin(String s) {
        return helper(s, new HashMap<String, Boolean>());
    }

    public boolean helper(String s, Map<String, Boolean> hm) {
        if (hm.containsKey(s)) {
            return hm.get(s);
        }
        if (s == null || s.length() < 2) {
            hm.put(s, false);
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("++")) {
                String sub = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                if (!helper(sub, hm)) {
                    hm.put(s, true);
                    return true;
                }
            }
        }
        hm.put(s, false);
        return false;
    }

}
