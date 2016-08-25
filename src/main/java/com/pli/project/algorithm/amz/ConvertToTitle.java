package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/24.
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
