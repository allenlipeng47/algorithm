package com.pli.project.algorithm.sort;

import java.util.HashMap;

/**
 * Created by lipeng on 2015/6/23.
 * Original problem is from g4g. http://www.geeksforgeeks.org/microsoft-interview-experience-set-54-for-sde/
 * Developed this problem to more generic one:
 String str = "BCDEAAA"; String sequence = "ABCDE";
 output should be: AAABCDE
 */
public class GroupSort {

    public static void groupSort(char[] str, char[] sequence){
        if(str==null||str.length<2||sequence==null||sequence.length<1||sequence.length > str.length){
            return;
        }
        int[] lenArr = new int[sequence.length];
        // initilization
        HashMap<Character, Integer> chrOrder = new HashMap<Character, Integer>();   //char order
        for(int i = 0; i<sequence.length; i++){
            chrOrder.put(sequence[i], i);
            if(str[0]==sequence[i]){
                lenArr[i]++;    //initialize the chr[0]
            }
        }
        for(int i=1;i<str.length;i++){
            int pos = i;
            boolean found = false;
            for(int j=lenArr.length-1 ;j>0 && pos>0;j--){
                if(chrOrder.get(str[pos])>=chrOrder.get(str[pos-1])){   //compare sequence order
                    lenArr[chrOrder.get(str[pos])]++;
                    found = true;
                    break;
                }
                else{
                    // exchange element with previous one
                    char tmp = str[pos];
                    str[pos] = str[pos - lenArr[j]];
                    str[pos - lenArr[j]] = tmp;
                    pos -= lenArr[j];
                } //if
            } //for j
            if(!found){
                //case could be: BBBCCCCDDDA, when next one is A, in this way, A won't be matched in above if clause
                lenArr[chrOrder.get(str[0])]++;
            }
        } //for i
    }

    public static void main(String[] args) {
        String str = "DCBAEECCAAABBAEEE";
        String sequence = "ABCDE";
        char[] chs = str.toCharArray();
        groupSort(chs, sequence.toCharArray());
        System.out.println(chs);
    }
}