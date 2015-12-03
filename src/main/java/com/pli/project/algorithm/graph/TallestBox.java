package com.pli.project.algorithm.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * Created by pli on 12/3/2015.
 * Given n boxes with length and width. A box with smaller length and smaller width can be put on a box with larger length and larger width.
 * Each box height is 1. Find the tallest box that they can put together.
 *
 * For n boxes, we do comparison between each box. If box[j] can be put on box[i], then we put an edge from box[i]->box[j].
 * In this way, we build a graph among boxes. Gathering all the boxes which doesn't has parent, we use BFS to iterate.
 * The max number of iteration will be the result.
 *
 */
public class TallestBox {

    public static int getTallestBox(int[][] boxes) {
        assert boxes!=null && boxes.length>0 && boxes[0]!=null && boxes[0].length>0;
        Queue<Node> mainQueue = initialStack(boxes);
        Queue<Node> auxQueue = new ArrayDeque<Node>();
        int tall = 0;
        while(!mainQueue.isEmpty()) {
            tall++;
            while (!mainQueue.isEmpty()) {
                Node node = mainQueue.remove();
                for(Node curr:node.neighbor) {
                    auxQueue.add(curr);
                }
            }
            Queue<Node> tmp = mainQueue;
            mainQueue = auxQueue;
            auxQueue = tmp;
        }
        return tall;
    }

    public static Queue<Node> initialStack(int[][] boxes) {
        boolean[] nonHeads = new boolean[boxes.length];
        Node[] nodes = new Node[boxes.length];
        Queue<Node> heads = new ArrayDeque<Node>();
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node(boxes[i]);
        }
        // build graph
        for(int i=0; i<nodes.length-1; i++) {
            for(int j=i+1; j<nodes.length; j++) {
                int compare = compare(nodes[i].box, nodes[j].box);
                switch (compare) {
                    case -1:
                        nodes[j].addNeighbor(nodes[i]);
                        nonHeads[i] = true;
                        break;
                    case 1:
                        nodes[i].addNeighbor(nodes[j]);
                        nonHeads[j] = true;
                        break;
                    case 0:
                        break;
                }// switch
            }// for
        }
        // mark head nodes who has out-going edge.
        for(int i=0; i<nonHeads.length; i++) {
            if (!nonHeads[i])
                heads.add(nodes[i]);
        }
        return heads;
    }

    /*
    Return 1 when arr1>arr2.
    Return -1 when arr1<arr2.
    Return 0 when arr1 can't compare to arr2.
     */
    public static int compare(int[] arr1, int[] arr2) {
        boolean larger = true;
        boolean smaller = true;
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i]<arr2[i])
                larger = false;
            else if(arr1[i]>arr2[i])
                smaller = false;
            else if(!larger && !smaller)
                return 0;
        }
        if(larger)
            return 1;
        else if(smaller)
            return -1;
        return 0;
    }

    public static class Node {
        public int[] box;
        public HashSet<Node> neighbor = new HashSet<Node>();
        public Node(int[] box) {
            this.box = box;
        }
        public void addNeighbor(Node node) {
            neighbor.add(node);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 5};
        int[][] boxes = {
                {0, 0},
                {1, 2},
                {1, 1},
                {3, 4},
                {4, 3},
                {4, 4},
                {3, 3}
        };
        System.out.println(getTallestBox(boxes));
    }

}
