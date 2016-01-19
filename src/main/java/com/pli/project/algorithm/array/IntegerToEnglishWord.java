package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/18.
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWord {

    public static final String BILLION = "Billion";
    public static final String MILLION = "Million";
    public static final String THOUSAND = "Thousand";
    public static final String HUNDRED = "Hundred";
    public static final String SPACE = " ";

    public static String getTens(int i) {
        switch (i) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    public static String getOnes(int i) {
        switch (i) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    public static String get3Digit(int i) {
        StringBuffer ans = new StringBuffer();
        int hundred = i / 100;
        if (hundred != 0)
            ans.append(getOnes(hundred) + SPACE + HUNDRED);
        i = i - hundred * 100;
        if (i == 0)
            return ans.toString();
        if (i > 0 && i < 20) {
            if (ans.length() != 0)
                ans.append(SPACE);
            ans.append(getOnes(i));
            return ans.toString();
        }
        int ten = i / 10;
        if (ans.length() != 0)
            ans.append(SPACE);
        ans.append(getTens(ten));
        i = i - ten * 10;
        if (i == 0)
            return ans.toString();
        if (ans.length() != 0)
            ans.append(SPACE);
        ans.append(getOnes(i));
        return ans.toString();
    }

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuffer ans = new StringBuffer();
        int one = num - num / 1000 * 1000;
        num /= 1000;
        if (one > 0)
            ans.append(get3Digit(one));
        int thousand = num - num / 1000 * 1000;
        num /= 1000;
        if (thousand > 0) {
            if (ans.length() != 0)
                ans.insert(0, SPACE);
            ans.insert(0, get3Digit(thousand) + SPACE + THOUSAND);
        }
        int million = num - num / 1000 * 1000;
        num /= 1000;
        if (million > 0) {
            if (ans.length() != 0)
                ans.insert(0, SPACE);
            ans.insert(0, get3Digit(million) + SPACE + MILLION);
        }
        if (num > 0) {
            if (ans.length() != 0)
                ans.insert(0, SPACE);
            ans.insert(0, get3Digit(num) + SPACE + BILLION);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 985411121;
        System.out.println(numberToWords(n));
    }


}
