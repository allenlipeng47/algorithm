package com.pli.project.algorithm.array;

import lombok.Data;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by pli on 7/17/2015.
 * Find if there is duplication elements in array, where they are less than k steps
 */
public class DuplicateInKLength {

    @Data
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        Point(Point p){
            this.x = p.x;
            this.y = p.y;
        }
    }

    private static void deleteLeftSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y--){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
        p.x++;
        p.y++;
        for(int i=0; i<radius; i++, p.x++, p.y++){
            deletePoint(arr, p, hs);
        }
    }

    private static void deleteRightSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
        p.x++;
        p.y--;
        for(int i=0; i<radius; i++, p.x++, p.y--){
            deletePoint(arr, p, hs);
        }
    }

    private static void deleteTopSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y - radius);
        for(int i=0; i<radius; i++, p.x--, p.y++){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
        p.x++;
        p.y++;
        for(int i=0; i<radius; i++, p.x++, p.y++){
            deletePoint(arr, p, hs);
        }
    }

    private static void deleteBottomSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y - radius);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
        p.x--;
        p.y++;
        for(int i=0; i<radius; i++, p.x--, p.y++){
            deletePoint(arr, p, hs);
        }
    }

    private static void deleteTopLeft(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y--){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
    }

    private static void deleteTopRight(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            deletePoint(arr, p, hs);
        }
        deletePoint(arr, p, hs);
    }

    private static void deletePoint(int[][] arr, Point p, Set<Integer> hs){
        if(p.x>=0 && p.x<arr.length && p.y>=0 && p.y<arr[0].length) {
            hs.remove(arr[p.x][p.y]);
            System.out.println("remove: " + arr[p.x][p.y]);
        }
    }

    private static boolean addLeftSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y--){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        p.x++;
        p.y++;
        for(int i=0; i<radius; i++, p.x++, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        return false;
    }

    private static boolean addRightSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x - radius, center.y);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        p.x++;
        p.y--;
        for(int i=0; i<radius; i++, p.x++, p.y--){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        return false;
    }

    private static boolean addTopSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y - radius);
        for(int i=0; i<radius; i++, p.x--, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        p.x++;
        p.y++;
        for(int i=0; i<radius; i++, p.x++, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        return false;
    }

    private static boolean addBottomSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y - radius);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        p.x--;
        p.y++;
        for(int i=0; i<radius; i++, p.x--, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        return false;
    }

    private static boolean addBottomLeftSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y - radius);
        for(int i=0; i<radius; i++, p.x++, p.y++){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        return false;
    }

    private static boolean addBottomRightSide(int[][] arr, Set<Integer> hs, Point center, int radius){
        Point p = new Point(center.x, center.y + radius);
        for(int i=0; i<radius; i++, p.x++, p.y--){
            if(addPoint(arr, p, hs)){
                return true;
            }
        }
        if(addPoint(arr, p, hs)){
            return true;
        }
        return false;
    }


    private static boolean addPoint(int[][] arr, Point p, Set<Integer> hs){
        if(p.x>=0 && p.x<arr.length && p.y>=0 && p.y<arr[0].length) {
            if(hs.contains(arr[p.x][p.y])){
                return true;
            }
            System.out.println("add: " + arr[p.x][p.y]);
            hs.add(arr[p.x][p.y]);
        }
        return false;
    }

    private static boolean checkEvenStep(int[][] arr, Set<Integer> hs, int k){
        int currLine = 0;
        Point point = new Point(0, 0);
        while(true){
            /* Move from left to right */
            point.x = currLine;
            for(int col=1; col < arr[0].length; col++){
                point.y = col - 1;
                deleteLeftSide(arr, hs, point, k);
                point.y = col;
                if(addRightSide(arr, hs, point, k)){
                    System.out.println(1);
                    return true;
                }
            }
            if(currLine>=arr.length){
                break;
            }
            /* Move down 1 step */
            deleteTopSide(arr, hs, point, k);
            point.x = ++currLine;
            if(addBottomSide(arr, hs, point, k)){
                System.out.println(2);
                return true;
            }
            /* Move from right to left */
            for(int col=arr[0].length-2; col>=0; col--){
                point.y = col + 1;
                deleteRightSide(arr, hs, point, k);
                point.y = col;
                if(addLeftSide(arr, hs, point, k)){
                    System.out.println(3);
                    return true;
                }
            }
            if(currLine>=arr.length){
                break;
            }
            /* Move down 1 step */
            deleteTopSide(arr, hs, point, k);
            point.x = ++currLine;
            if(addBottomSide(arr, hs, point, k)){
                System.out.println(4);
                return true;
            }
        }
        return false;
    }

    private static boolean checkOddStep(int[][] arr, Set<Integer> hs, int k){
        int currLine = 0;
        Point point = new Point(0, 0);
        if(checkTopBottom(arr, point, k)){
            return true;
        }
        while(true){
            /* Move from left to right */
            point.x = currLine;
            for(int col=1; col < arr[0].length; col++){
                point.y = col - 2;
                deleteLeftSide(arr, hs, point, k);
                point.y = col;
                if(addRightSide(arr, hs, point, k) || checkTopBottom(arr, point, k)){
                    System.out.println(1);
                    return true;
                }
            }
            if(currLine>=arr.length){
                break;
            }
            /* Move down 1 step */
            deleteTopLeft(arr, hs, new Point(point.x, point.y-1), k);
            deletePoint(arr, new Point(point.x - k, point.y), hs);
            point.x = ++currLine;
            if(addBottomLeftSide(arr, hs, new Point(point.x, point.y-1), k) || checkTopBottom(arr, point, k)){
                System.out.println(2);
                return true;
            }
            if(addPoint(arr, new Point(point.x + k, point.y), hs)){
                System.out.println(2.2);
                return true;
            }
            /* Move from right to left */
            for(int col=arr[0].length-2; col>=0; col--){
                point.y = col;
                deleteRightSide(arr, hs, new Point(point.x, col+1), k);
                if(addLeftSide(arr, hs, new Point(point.x, col - 1), k) || checkTopBottom(arr, point, k)){
                    System.out.println(3);
                    return true;
                }
            }
            if(currLine>=arr.length){
                break;
            }
            /* Move down 1 step */
            deleteTopRight(arr, hs, point, k);
            deletePoint(arr, new Point(point.x - k, point.y - 1), hs);
            point.x = ++currLine;
            if(addBottomRightSide(arr, hs, point, k) || checkTopBottom(arr, point, k)){
                System.out.println(4);
                return true;
            }
        }
        return false;
    }

    private static boolean checkTopBottom(int[][] arr, Point point, int k){
        if(point.x-k<0 || point.x+k+1>=arr.length || point.y<0 || point.y>=arr[0].length){
            return false;
        }
        return arr[point.x-k][point.y]==arr[point.x+k+1][point.y];
    }

    public static boolean containDuplicate(int[][] arr, int k){
        Set<Integer> hs = new HashSet<Integer>();
        /** Initialize hashset **/
        for(int i=0; i <= k/2; i++){
            for(int x=0, y=i; y>=0; x++, y--){
                if(x>=arr.length || y>=arr[0].length){
                    continue;
                }
                if(hs.contains(arr[x][y])){
                    return true;
                }
                else {
                    hs.add(arr[x][y]);
                }
            }
        }
        if(k%2 == 0){
            return checkEvenStep(arr, hs, k/2);
        }
        else if(k%2 == 1){
            return checkOddStep(arr, hs, k / 2);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,  2,  3,  4,  5,  6,  7},
                {8,  9,  10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 41, 42},
                {43, 44, 45, 46, 47, 48, 49},
                {50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63},
                {64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77}
        };
        boolean result = containDuplicate(arr, 1);
        System.out.println(result);
    }

}