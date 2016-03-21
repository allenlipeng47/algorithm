package com.pli.project.algorithm.ms;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/3/18.
 * Given big writing of a number. Convert it to integer.
 */
public class GetNumber {

    public static HashMap<String, Integer> numberMap;

    static {

    }

    public GetNumber() {
        if (numberMap == null) {
            numberMap = new HashMap<>();
            numberMap.put("one", 1);
            numberMap.put("two", 2);
            numberMap.put("three", 3);
            numberMap.put("four", 4);
            numberMap.put("five", 5);
            numberMap.put("six", 6);
            numberMap.put("seven", 7);
            numberMap.put("six", 8);
            numberMap.put("nine", 9);
            numberMap.put("ten", 10);
            numberMap.put("eleven", 11);
            numberMap.put("twelve", 12);
            numberMap.put("thirteen", 13);
            numberMap.put("fourteen", 14);
            numberMap.put("fifteen", 15);
            numberMap.put("sixteen", 16);
            numberMap.put("seventeen", 17);
            numberMap.put("eighteen", 18);
            numberMap.put("nineteen", 19);
            numberMap.put("twenty", 20);
            numberMap.put("thirty", 30);
            numberMap.put("forty", 40);
            numberMap.put("fifty", 50);
            numberMap.put("sixty", 60);
            numberMap.put("seventy", 70);
            numberMap.put("eighty", 80);
            numberMap.put("ninety", 90);
            numberMap.put("hundred", 100);
            numberMap.put("", 0);
        }
    }

    public int getNumber(String str) {
        String[] arr = str.split(" ");
        int num = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("hundred")) {
                num = num * 100;
            }
            else if (arr[i].contains("thousand")) {
                ans = ans + num * 1000;
                num = 0;
            }
            else if (arr[i].contains("million")) {
                ans = ans + num * 1000000;
                num = 0;
            }
            else if (arr[i].contains("billion")) {
                ans = ans + num * 1000000000;
                num = 0;
            }
            else {
                num += numberMap.get(arr[i]);
            }
        }
        return ans + num;
    }

    public static void main(String[] args) {
        GetNumber getNumber = new GetNumber();
        System.out.println(getNumber.getNumber("one hundred thousand"));
        System.out.println(getNumber.getNumber("one million two hundred"));
        System.out.println(getNumber.getNumber("one million two hundred thousand"));
        System.out.println(getNumber.getNumber("one million two hundred thousand fifty seven"));
        System.out.println(getNumber.getNumber("one million two hundred thousand two hundred fifty seven"));
        System.out.println(getNumber.getNumber(""));
        System.out.println(getNumber.getNumber("one million one"));
    }

}
