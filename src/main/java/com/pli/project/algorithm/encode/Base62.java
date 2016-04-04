package com.pli.project.algorithm.encode;


/**
 * Created by lipeng on 2015/11/29.
 * http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 * How to design a system that takes big URLs like ¡°http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/¡±
 * and converts them into a short 6 character URL. It is given that URLs are stored in database and every URL has an associated integer id.
 */
public class Base62 {

    public static long shortUrlToNumber(String url) {
        int base = 62;
        long id = 0;
        for(int i=0; i<url.length(); i++) {
            char ch = url.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                id = id * base + ch - 'a';
            }
            else if (ch >= 'A' && ch <= 'Z') {
                id = id * base + ch - 'A' + 26;
            }
            else if (ch>='0' && ch <='9') {
                id = id * base + ch - '0' + 52;
            }
            else {
                return -1;
            }
        }
        return id;
    }

    public static String numberToShortUrl(long id) {
        char[] chs = {  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int base = 62;
        StringBuffer sb = new StringBuffer();
        while(id>0) {
            sb.insert(0, chs[(int) (id % base)]);
            id = id / base;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToShortUrl(32145l));
        System.out.println(shortUrlToNumber("LyUKgalnVLk"));
    }

}
