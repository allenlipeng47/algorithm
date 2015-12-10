package com.pli.project.algorithm.recursion;

/**
 * Created by lipeng on 2015/12/9.
 */
public class IsNumber {

    public static int pos = 0;

    public static String str = null;

    public static boolean isNumber(String str2) {
        str = str2.replaceAll("\\d+", "d").replaceAll(" +", " ");  //replace all number to d
        pos = 0;
        System.out.print(str2 + ":");
        return g();
    }

    //G=P|PeP
    public static boolean g() {
        if(p()) {
            if(pos==str.length()) {
                return true;
            }
            if(pos<str.length() && str.charAt(pos)=='e') {
                pos++;
                if(p() && pos==str.length())
                    return true;
                pos--;
            }
        }
        return false;
    }

    //p=sn
    public static boolean p() {
        if(s() && n())
            return true;
        return false;
    }

    //s=+|-|empty
    public static boolean s() {
        if(pos<str.length() && (str.charAt(pos)=='+'||str.charAt(pos)=='-')) {
            pos++;
            return true;
        }
        return true;
    }

    //n=d|.d|d.|d.d
    public static boolean n() {
        if(pos<=str.length()-4 && str.substring(pos, pos+3).equals("d.d ")) {
            pos = pos + 4;
            return true;
        }
        if(pos<=str.length()-3 && (
                str.substring(pos, pos+3).equals("d.d")
                        || str.substring(pos, pos+3).equals(".d ")
                        || str.substring(pos, pos+3).equals(" d.")
                        || str.substring(pos, pos+3).equals("d. ")
                        || str.substring(pos, pos+3).equals(" .d")
                        || str.substring(pos, pos+3).equals(" d ")
        )) {
            pos = pos + 3;
            return true;
        }
        if(pos<=str.length()-2 && (
                str.substring(pos, pos+2).equals(".d")
                        || str.substring(pos, pos+2).equals("d.")
                        || str.substring(pos, pos+2).equals("d ")
                        || str.substring(pos, pos+2).equals(".d")
                        || str.substring(pos, pos+2).equals(" d")
        )) {
            pos = pos + 2;
            return true;
        }
        if(pos<=str.length()-1 && str.substring(pos, pos+1).equals("d")) {
            pos++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("+1.2"));
        System.out.println(isNumber("1"));
        System.out.println(isNumber("-1.2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("124"));
        System.out.println(isNumber("12 4"));
        System.out.println(isNumber("1ab"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber("2e10e1"));
        System.out.println(isNumber("-"));
        System.out.println(isNumber("1."));
        System.out.println(isNumber("1e"));
        System.out.println(isNumber("1"));
        System.out.println(isNumber("3."));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("-."));
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber(".2e12"));
        System.out.println(isNumber(".2e+2"));
        System.out.println(isNumber(".2e-2"));
        System.out.println(isNumber(" 1"));
        System.out.println(isNumber(" 1."));
        System.out.println(isNumber("1  "));
        System.out.println(isNumber("1.  "));
        System.out.println(isNumber(" .9"));
        System.out.println(isNumber(" 0 "));
        System.out.println(isNumber("+ 1"));
    }
}
