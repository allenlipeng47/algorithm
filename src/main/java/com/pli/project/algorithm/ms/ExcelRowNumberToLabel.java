package com.pli.project.algorithm.ms;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/18.
 */
public class ExcelRowNumberToLabel {

    public String convertToTitle(int number) {
        StringBuffer sb = new StringBuffer();
        while (number > 0) {
            number--;
            sb.insert(0, (char)('A' + number % 26));
            number /= 26;
        }
        return sb.toString();
    }

    public int restoreNumber(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * 26 + str.charAt(i) - 'A' + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        ExcelRowNumberToLabel excel = new ExcelRowNumberToLabel();
        String label = excel.convertToTitle(27);
        System.out.println(label);
        System.out.println(excel.restoreNumber(label));
    }



}
