package com.pli.project.algorithm.amz;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/21.
 */
public class RemoveDupLettters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] rec = new int[26];
        for (int i = 0; i < s.length(); i++) {
            rec[s.charAt(i) - 'a']++;
        }
        int i = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            if (visited[ch - 'a']) {
                i++;
                rec[ch - 'a']--;
                continue;
            }
            if (!stack.isEmpty() && ch < stack.peek() && rec[stack.peek() - 'a'] > 0) {
                char pop = stack.pop();
                visited[pop - 'a'] = false;
            }
            else {
                stack.add(ch);
                rec[ch - 'a']--;
                visited[ch - 'a'] = true;
                i++;
            }
        }
        StringBuffer sb = new StringBuffer();
        stack.forEach(p -> sb.append(p));
        return sb.toString();
    }

}
