package com.pli.project.algorithm.recursion;

/**
 * Created by lipeng on 2015/12/16.
 */
public class SimpleRegularExpression {

    public static boolean isMatch(String str, String reg) {
        assert str!=null && reg!=null;
        return matchHelper(str, reg, 0, 0);
    }

    public static boolean matchHelper(String str, String reg, int i, int j) {
        if(i==str.length() && j==reg.length())
            return true;
        if((i>=str.length() && str.length()>0) || j>=reg.length())
            return false;
        if(j<reg.length() -1 && reg.charAt(j + 1)=='*') // because char after j is *, so we should decide where to skip * in reg
            if (matchHelper(str, reg, i, j + 2)) {  // consider * is 0 times
                return true;
            } else    // consider * happens from 1, 2 and more times
                for (; i < str.length() && (str.charAt(i) == reg.charAt(j) || reg.charAt(j) == '.'); i++)
                    if (matchHelper(str, reg, i + 1, j + 2))
                        return true;
        return (str.charAt(i)==reg.charAt(j) || reg.charAt(j)=='.') && matchHelper(str, reg, i+1, j+1);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", "c*abd"));
    }

}
