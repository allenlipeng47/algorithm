package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2015/5/28.
 */
/**
 * Created by PLi on 5/28/2015.
 */
public class LeastPerfectSquare {


    public static void main(String[] args) {
        int leastSquare = leastPerfectSquare3(12);
        System.out.println(leastSquare);
    }

    /** Inefficient version */
    static int leastPerfectSquare1(int n){
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
        int maxSquare = (int)Math.sqrt(n);
        int result = n;
        for(int i=1;i<=maxSquare; i++){
            int tmpResult = leastPerfectSquare1(n - (int) Math.pow(i, 2)) + 1;
            result = (tmpResult < result) ? tmpResult : result;
        }
        return result;
    }

    /** Recursion storing sub solutions **/
    static int leastPerfectSquare2(int n){
        int[] storedResult = new int[n + 1];
        storedResult[1] = 1;
        return leastPerfectSquare2Helper(n, storedResult);
    }

    static int leastPerfectSquare2Helper(int n, int[] storedResult){
        if(n==0){
            return 0;
        }
        int maxSquare = (int)Math.sqrt(n);
        int result = n;
        for(int i=1;i<=maxSquare; i++){
            int power = (int)Math.pow(i, 2);
            int tmpResult = 0;
            if(storedResult[n - power]!=0){
                tmpResult = storedResult[n - power] + 1;
            }
            else {
                tmpResult = leastPerfectSquare2Helper(n - power, storedResult) + 1;
            }
            result = (tmpResult < result) ? tmpResult : result;
        }
        storedResult[n] = result;
        return result;
    }

    /** Non-recursion solution **/
    static int leastPerfectSquare3(int n){
        int[] table = new int[n+1];
        for(int i=0;i<n+1;i++){
            table[i] = i;
        }
        int maxSquare = (int) Math.sqrt(n);
        for(int i=2; i<=maxSquare; i++){
            int power = (int) Math.pow(i, 2);
            int boundary = n - power;
            for(int j=0;j<=boundary; j++){
                if(table[j] + 1 < table[j+power] ){
                    table[j+power] = table[j] + 1;
                }
            }
        }
        return table[n];
    }

}