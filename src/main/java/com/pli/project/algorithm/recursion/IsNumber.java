package com.pli.project.algorithm.recursion;

/**
 * Created by lipeng on 2015/12/9.
 */
public class IsNumber {

    public static int pos = 0;

    public static String str = null;

    public static boolean isNumber(String str2) {
        str = str2.replaceAll("\\d+", "d").trim();  //replace all number to d
        pos = 0;
        System.out.print(str2 + ":");
        return g();
    }

    //G=P|PeQ
    public static boolean g() {
        if(p()) {
            if(pos==str.length()) {
                return true;
            }
            if(pos<str.length() && str.charAt(pos)=='e') {
                pos++;
                if(q() && pos==str.length())
                    return true;
                pos--;
            }
        }
        return false;
    }

    //P=SR
    public static boolean p() {
        if(s() && r())
            return true;
        return false;
    }

    //Q=SI
    public static boolean q() {
        if(s() && i())
            return true;
        return false;
    }

    //S=+|-|empty
    public static boolean s() {
        if(pos<str.length() && (str.charAt(pos)=='+'||str.charAt(pos)=='-')) {
            pos++;
            return true;
        }
        return true;
    }

    //R=D|.D|D.|D.D
    public static boolean r() {
        if(pos<=str.length()-3 && (
                str.substring(pos, pos+3).equals("d.d")
                        || str.substring(pos, pos+3).equals(" d ")
        )) {
            pos = pos + 3;
            return true;
        }
        if(pos<=str.length()-2 && (
                str.substring(pos, pos+2).equals(".d")
                        || str.substring(pos, pos+2).equals("d.")
                        || str.substring(pos, pos+2).equals(".d")
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

    //I=D
    public static boolean i() {
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
        System.out.println(isNumber("6e6.5"));
        System.out.println(isNumber(" 0"));
        System.out.println(isNumber("96 5e"));
        System.out.println(isNumber("+3. e04116"));
    }
}
