package com.pli.project.algorithm.recursion;

/**
 * Created by lipeng on 2015/10/27.
 */
public class SimpleRegularExpression {

    public static boolean matchReg(String str, String reg) {
        return matchRegUtil(str, 0, reg, 0);
    }

    public static boolean matchRegUtil(String str, int strPos, String reg, int regPos) {
        if(strPos>=str.length() && regPos>=reg.length()) {
            return true;
        }
        else if(regPos>=reg.length()) {
            return false;
        }
        else if(strPos>=str.length()) {
            for(int i=regPos; i<reg.length(); i++) {
                if(reg.charAt(i)!='*') {
                    return false;
                }
            }
            return true;
        }
        if(reg.charAt(regPos)==str.charAt(strPos)||reg.charAt(regPos)=='?') {
            return matchRegUtil(str, strPos+1, reg, regPos+1);
        }
        else if(reg.charAt(regPos)=='*'){
            for(int i=strPos-1; i<str.length(); i++) {
                if(matchRegUtil(str, i+1, reg, regPos+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abc";
        String reg = "ab?e";
        System.out.println(matchReg(str, reg));
    }

}
