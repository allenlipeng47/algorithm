package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

    public String addBinary2(String a, String b) {
        int lenA = a.length(), lenB = b.length(), carrier = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lenA || i < lenB || carrier > 0; i++) {
            int num = 0;
            if (lenA - i - 1 >= 0) {
                num += Integer.parseInt(a.substring(lenA - i - 1, lenA - i));
            }
            if (lenB - i - 1 >= 0) {
                num += Integer.parseInt(b.substring(lenB - i - 1, lenB - i));
            }
            num += carrier;
            sb.insert(0, num % 2);
            carrier = num / 2;
        }
        return sb.toString();
    }

    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        for (int i = a.length() - 1, j = b.length() - 1, carrier = 0;
             i >= 0 || j >= 0 || carrier > 0; i--, j--) {
            int num = carrier;
            if (i >= 0) {
                num += a.charAt(i) - '0';
            }
            if (j >= 0) {
                num += b.charAt(j) - '0';
            }
            sb.insert(0, num % 2);
            carrier = num / 2;
        }
        return sb.toString();
    }

}
