package com.pli.project.algorithm.string;

import java.util.*;

/**
 * Created by lipeng on 2016/1/3.
 */
public class RemoveDuplicateLetter {



    public static String removeDuplicateLetters(String str) {
        int[] nums = new int[26];
        char[] chs = str.toCharArray();
        for(char ch : chs)
            nums[ch - 'a']++;
        Stack<Character> s = new Stack<Character>();
        s.add('0');
        boolean[] visited = new boolean[26];
        for(char ch : chs) {
            nums[ch - 'a']--;
            if(visited[ch - 'a'])
                continue;
            char topCh;
            while ((topCh = s.peek()) > ch && nums[topCh - 'a'] > 0) {
                visited[topCh - 'a'] = false;
                s.pop();
            }
            s.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuffer ans = new StringBuffer();
        while (s.size() > 1)
            ans.insert(0, s.pop());
        return ans.toString();
    }

    public static void main(String[] args) {
//        String str = "cbacdcbc";
        String str = "bcabc";
        System.out.println(removeDuplicateLetters(str));
    }

}
