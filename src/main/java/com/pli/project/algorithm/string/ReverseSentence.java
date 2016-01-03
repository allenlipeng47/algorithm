package com.pli.project.algorithm.string;

/**
 * Created by lipeng on 2015/12/12.
 * Given "hello world" -> "world hello"
 * Given "abc def ghi" -> "ghi def abc"
 */
public class ReverseSentence {

    public static String reverseSentence(String str) {
        assert str!=null;
        StringBuffer result = new StringBuffer();
        int endPos = str.length();
        for(int pos=str.lastIndexOf(" "); pos>=0; endPos=pos, pos=str.lastIndexOf(" ", pos-1)) {
            result.append(str.substring(pos+1, endPos) + " ");
        }
        result.append(str.substring(0, endPos));
        return result.toString().trim();
    }


    public static void main(String[] args) {
        String str = "";
        System.out.println(reverseSentence(str));
    }
}
