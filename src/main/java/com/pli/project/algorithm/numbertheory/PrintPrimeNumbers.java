package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2015/11/21.
 * Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
 For example, if n is 10, the output should be ¡°2, 3, 5, 7¡å. If n is 20, the output should be ¡°2, 3, 5, 7, 11, 13, 17, 19¡å.
 This is an implementation of Sieve of Eratosthenes.
 http://www.geeksforgeeks.org/sieve-of-eratosthenes/
 */
public class PrintPrimeNumbers {

    public static void printPrime(int n) {
        boolean[] prime = new boolean[n+1];
        for(int i=2; i<n; i++) {
            if(prime[i]==true) {
                continue;
            }
            System.out.println(i);
            for(int curr=i, j=2; curr*j<n; j++) {
                prime[curr*j] = true;
            }
        }
    }

    public static void main(String[] args) {
        printPrime(20);
    }
}
