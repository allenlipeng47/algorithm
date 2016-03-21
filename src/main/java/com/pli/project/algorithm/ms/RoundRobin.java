package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/18.
 */
public class RoundRobin {

    public void roundRobin(int team) {
        int round = team - 1;
        int[] arr = new int[team];
        for (int i = 0; i < team; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < team >> 1; j++) {
                System.out.print(arr[j] + "," + arr[j + team / 2] + "\t");
            }
            System.out.println();
            int tmp = arr[0];
            for (int j = 0; j < team - 2; j++) {
                arr[j] = arr[j + 1];
            }
            arr[team - 2] = tmp;
        }
    }

    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();
        roundRobin.roundRobin(4);
    }

}
