package com.pli.project.algorithm.recursion;

/**
 * Created by lipeng on 2015/12/16.
 *
 If reg.charAt[j] is not "." or "*", dp[i][j]=dp[i-1][j-1] && reg.charAt(i)==str.chartAt(j)
 If reg.charAt[j]==".", dp[i][j]=dp[i-1][j-1]
 If reg.charAt[j]=="*",
    (1)if dp[i-2][j] is true, then dp[i][j]=true. This considers * has 0 times.
    (2)If str[i-1]==true, move from dp[i][j] to right until str[j]!=reg[i-1]. This considers * has 1, 2, or more times.
 */
public class SimpleRegularExpressionDp {

    public static boolean isMatch(String str, String reg) {
        assert str!=null && reg!=null;
        str = "$" + str;
        reg = "$" + reg;
        boolean[][] dp = new boolean[reg.length()][str.length()];
        dp[0][0] = true;
        for(int i=1; i<reg.length(); i++) {
            if (reg.charAt(i) == '.') {
                for (int j = 1; j < str.length(); j++)
                    dp[i][j] = dp[i-1][j-1];
            } else if (reg.charAt(i) != '*') {
                for (int j = 1; j < str.length(); j++)
                    dp[i][j] = dp[i-1][j-1] && reg.charAt(i) == str.charAt(j);
            } else {
                int j=0;
                while(j<str.length()) {
                    if(dp[i-1][j])  // * represents 1, 2, 3 and more times
                        while(j<str.length() && (reg.charAt(i-1)==str.charAt(j) || reg.charAt(i-1)=='.')) {
                            dp[i][j++] = true;
                        }
                    if(j<str.length())  // * represents 0 times.
                        dp[i][j] = dp[i][j] || (i>=2 && dp[i-2][j]);
                    j++;
                } // while
            } // if
        } // for
        return dp[reg.length()-1][str.length()-1];
    }


    public static void main(String[] args) {
//        System.out.println(isMatch("ab", "c*abd"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

}
