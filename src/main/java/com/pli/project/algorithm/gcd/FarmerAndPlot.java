package com.pli.project.algorithm.gcd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by lipeng on 2015/9/4.
 */
class FarmerAndPlot {

    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(b > a){
            int tmp = b; b = a; a = tmp;
        }
        if(b==0){
            return a;
        }
        int remainder = 0;
        do {
            remainder = a - b;
            a = b;
            b = remainder;
        } while(remainder!=0);
        return a;
    }

    public static int findMinEqualSize(int a, int b){
        int gcd = gcd(a, b);
        return a * b / gcd / gcd;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String line;
        int inputNum = Integer.valueOf(sc.nextLine());
        int[][] inputPara = new int[inputNum][2];
        int paraNum = 0;
        for(int i=0; i<inputNum; i++){
            line = sc.nextLine();
            inputPara[i][0] = Integer.valueOf(line.substring(0, line.indexOf(' ')));
            inputPara[i][1] = Integer.valueOf(line.substring(line.indexOf(' ') + 1, line.length()));
            paraNum++;
        }
        for(int i=0; i<inputNum; i++){
            System.out.println(findMinEqualSize(inputPara[i][0], inputPara[i][1]));
        }

    }

}
