package com.pli.project;

import java.util.Arrays;

public class PhoneNumberGenerator {

    private static String[] sections = {"asdf", "Adsf"};
    private static final int MAX_NUMBER_LEN = 11;

    // 用于生成某些号段的手机号码。并且包括pattern
    public static void generatePhoneNumber(String[] sections, String pattern) {
        for (String section : sections) {
            int maxNum = maxByLength(MAX_NUMBER_LEN - section.length() - pattern.length());
            for (int i = 0; i < maxNum; i++) {
                String toBeSplitted = autoGenericCode(String.valueOf(i), MAX_NUMBER_LEN -  section.length() - pattern.length());
                String[][] fullySplit = fullySplit(toBeSplitted);
                for (String[] split : fullySplit) {
                    String ans = String.format("%s%s%s%s", section, split[0], pattern, split[1]);
                    System.out.println(ans);
                }
            }
        }

    }

    public static void main(String[] args) {
        generatePhoneNumber(new String[]{"1375959", "1375960"}, "88");
    }

    private static int maxByLength(int len) {
        return (int)Math.pow(10, len);
    }

    private static String[][] fullySplit(String s) {
        String ans[][] = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            ans[i][0] = s.substring(0, i);
            ans[i][1] = s.substring(i, s.length());
        }
        return ans;
    }

    private static String autoGenericCode(String code, int num) {
        String result = "";
        result = String.format("%0" + num + "d", Integer.parseInt(code) + 1);
        return result;
    }
}