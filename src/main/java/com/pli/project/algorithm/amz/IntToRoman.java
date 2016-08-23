package com.pli.project.algorithm.amz;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/integer-to-roman/
 * Add 4 and 9. Each time, try the topest Roman number.
 */
public class IntToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(9);
        stack.push(10);
        stack.push(40);
        stack.push(50);
        stack.push(90);
        stack.push(100);
        stack.push(400);
        stack.push(500);
        stack.push(900);
        stack.push(1000);
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            if (stack.peek() <= num) {
                sb.append(map.get(stack.peek()));
                num -= stack.peek();
            }
            else {
                stack.pop();
            }
        }
        return sb.toString();
    }

}
