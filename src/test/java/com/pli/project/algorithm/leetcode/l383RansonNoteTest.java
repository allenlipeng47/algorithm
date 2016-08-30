package com.pli.project.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/29.
 * https://leetcode.com/problems/ransom-note/
 */
public class l383RansonNoteTest {

    @Test
    public void test1() {
        l383RansonNote l = new l383RansonNote();
        assert l.canConstruct("aa", "ab") == false;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            int count = hm.getOrDefault(ch, 0);
            hm.putIfAbsent(ch, count + 1);
        }
        for (char ch : magazine.toCharArray()) {
            Integer count = hm.get(ch);
            if (count == null) {
                continue;
            }
            else if (count < 0) {
                return false;
            }
            else if (count == 1) {
                hm.remove(ch);
            }
            else {
                hm.put(ch, count - 1);
            }
        }
        return hm.isEmpty();
    }
}
