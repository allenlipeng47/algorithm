package com.pli.project.algorithm.probability;

/**
 * Created by lipeng on 2016/2/6.
 */
public class ReturnWithProbabilityProportionalToItsWeight {

    public static int getRandom(int[][] input) {
        double totalWeight = input[0][1];
        int result = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] == 0 && input[i][1] == 0) {
                break;
            }
            double newTotalWeight = totalWeight + input[i][1];
            double newChance = ((double) input[i][1]) / newTotalWeight;
            if (Math.random() <= newChance) {
                result = i;
            }
            totalWeight = newTotalWeight;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 4 }, { 2, 2 }, { 3, 2 }, { 0, 0 } };
        int result = getRandom(input);
        System.out.println(result);
        /*
         * Following runs for 1000 times to check the answer correctness.
         *
         * int[] test = new int[3]; for (int i = 0; i < 1000; i++) {
         * test[getRandom(input)]++; } for (int i = 0; i < test.length; i++) {
         * System.out.print(test[i] + ¡°\t¡±); }
         */
    }
}