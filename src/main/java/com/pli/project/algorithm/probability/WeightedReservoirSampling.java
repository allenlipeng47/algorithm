package com.pli.project.algorithm.probability;

import java.util.*;

/**
 * Created by lipeng on 2015/5/25.
 */
public class WeightedReservoirSampling {

    public static int[] weightedReservoirSampling(int[][] items, int m){
        if(items==null || m > items.length){
            System.out.println("incorrect input.");
            return null;
        }
        PriorityQueue<WrsElement> heap = new PriorityQueue<WrsElement>(10);
        /** Transform weight into a double between (0,1). Put it in min heap. **/
        for(int i=0; i < items.length ; i++){
            double key = Math.pow((Math.random()), 1/(double)items[i][1]);
            WrsElement element = new WrsElement(items[i][0], key);
            heap.add(element);
            if(heap.size() > m){
                heap.poll();
            }
        }
        /** Output result. **/
        int[] result = new int[m];
        for(int i=0;i<m; i++){
            result[i] = heap.poll().value;
        }
        return result;
    }

    static class WrsElement implements Comparable<WrsElement>{

        int value;
        double key;

        public WrsElement(int value, double key){
            this.value = value;
            this.key = key;
        }

        public int compareTo(WrsElement wrsElement) {
            return Double.compare(this.key, wrsElement.key);
        }

        @Override
        public String toString() {
            return "WrsElement{" +
                    "val=" + value +
                    ", key=" + key +
                    '}';
        }
    }

    public static void main(String[] args) {
        /** each item = {id, weight} **/
        int[][] items = {
                {1, 1}, {2, 5}, {3, 20}, {4, 5}, {5, 10}, {6, 3}, {7, 3}, {8, 3}
        };
        int[] result = weightedReservoirSampling(items, 3);
        System.out.println(Arrays.toString(result));
    }

    public static void test(){
        int[][] items = {{0, 2}, {1, 1}, {2, 1}, {3, 1}, {4, 1} };
        int m = 2;
        int[] probabilities = new int[items.length];
        for(int i=0; i< 1000; i++) {
            int[] result = weightedReservoirSampling(items, m);
            for(int j = 0; j < m; j++){
                probabilities[result[j]]++;
            }
        }
        System.out.println(Arrays.toString(probabilities));
    }

}
