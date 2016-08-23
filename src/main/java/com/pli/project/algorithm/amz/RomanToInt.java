package com.pli.project.algorithm.amz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/22.
 */
public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0, last = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            curr = curr < last ? -curr : curr;
            ans += curr;
            last = curr;
        }
        return ans;
    }

}
