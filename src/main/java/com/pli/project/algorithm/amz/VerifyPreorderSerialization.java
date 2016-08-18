package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/17.
 */
public class VerifyPreorderSerialization {

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(" ");
        int num = 1;
        for (String str : strs) {
            if (--num < 0) {
                return false;
            }
            if (!"#".equals(str)) {
                num += 2;
            }
        }
        return num == 0;
    }

}
