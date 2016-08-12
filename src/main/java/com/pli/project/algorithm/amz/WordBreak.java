package com.pli.project.algorithm.amz;

import java.util.Set;

/**
 * Created by lipeng on 2016/8/11.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
