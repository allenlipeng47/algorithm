package com.pli.project.algorithm.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/3/18.
 * Given a string. Shuffle it and get all combinations. 2 same characters can't stay together.
 */
public class ShuffleString {

    public static List<String> shuffleString(String str) {
        List<String> ans = new ArrayList<>();
        shuffleStringHelper(str, ans, new StringBuffer(), new boolean[str.length()]);
        return ans;
    }

    public static void shuffleStringHelper(String str, List<String> ans, StringBuffer curr, boolean[] visited) {
        if (curr.length() >= str.length()) {
            ans.add(curr.toString());
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || curr.length() > 0 && curr.charAt(curr.length() - 1) == str.charAt(i)
                    || i > 0 && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            curr.append(str.charAt(i));
            shuffleStringHelper(str, ans, curr, visited);
            curr.deleteCharAt(curr.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "AABC";
        List<String> ans = shuffleString(str);
        System.out.println(ans);
    }
}
