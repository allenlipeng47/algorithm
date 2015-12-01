package com.pli.project.algorithm.dp;

import java.util.Stack;

/**
 * Created by lipeng on 2015/11/27.
 * Given a, n, calculate a^n in non-recursive way.
 */
public class PowerInNonRecursive {

    public static int power2(int a, int n) {
        // build stack
        Stack<Integer> s = new Stack();
        s.add(n);
        while(s.peek()>1) {
            int curr = s.pop();
            s.push(curr%2); //1 means result should time a.
            s.push(-1); //-1 means result should time result.
            s.push(curr/2);
        }
        int result = 1;
        while(!s.isEmpty()) {
            int curr = s.pop();
            switch (curr) {
                case 1:
                    result = result * a;
                    break;
                case -1:
                    result = result * result;
                    break;
            }
        }
        return result;
    }

    public static int power(int a, int n) {
        int result = 1;
        while(n>0) {
            if(n%2==1)
                result = result * a;
            a = a * a;
            n = n>>1;
        }
        return result;
    }

    /*
    According to formula https://en.wikipedia.org/wiki/Exponentiation#Efficient_computation_with_integer_exponents
     */
    public static int power3(int a, int n)  {
        int result = 0;
        while(n>0) {
            if((n&0x1)==1) {
                result = result * a;
            }
            result = result * result;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 0));
    }


}
