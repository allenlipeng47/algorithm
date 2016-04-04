package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by lipeng on 2015/11/8.
 */
public class RangeScan {

    public static class Node {
        public int x;
        public int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class AuxNodeX implements Comparable<AuxNodeX> {
        //Node ordered by X axis
        Node node;
        AuxNodeX(Node node) {
            this.node = node;
        }
        public int compareTo(AuxNodeX node) {
            return this.node.x - node.node.x;
        }
    }

    public static class AuxNodeY implements Comparable<AuxNodeY>{
        //Node ordered by Y axis
        Node node;
        AuxNodeY(Node node) {
            this.node = node;
        }
        public int compareTo(AuxNodeY node) {
            return this.node.y - node.node.y;
        }
    }

    public static ArrayList<Node> getRange(ArrayList<Node> nodes, Node range) {
        AuxNodeX[] nodeXs = new AuxNodeX[nodes.size()];
        AuxNodeY[] nodeYs = new AuxNodeY[nodes.size()];
        Iterator<Node> itr = nodes.iterator();
        int i=0;
        while(itr.hasNext()) {
            Node node = itr.next();
            nodeXs[i] = new AuxNodeX(node);
            nodeYs[i] = new AuxNodeY(node);
            i++;
        }
        Arrays.sort(nodeXs);
        Arrays.sort(nodeYs);
        int left=0, right=nodes.size(), mid=nodes.size()/2;
        while(left<right) {
            if(nodeXs[mid].node.x<range.x) {
                left = mid;
            }
            else if(nodeXs[mid-1].node.x>range.x) {
                right = mid;
            }
            else {
                break;
            }
            mid = (left+right)/2;
        }
        int xStart = mid;
        left=0; right=nodes.size(); mid=nodes.size()/2;
        while(left<right) {
            if(nodeYs[mid].node.x<range.x) {
                left = mid;
            }
            else if(nodeYs[mid-1].node.x>range.x) {
                right = mid;
            }
            else {
                break;
            }
            mid = (left+right)/2;
        }
        int yStart = mid;
        left=0; right=nodes.size(); mid=nodes.size()/2;
        while(left<right) {
            if(nodeXs[mid].node.y>range.y) {
                right = mid;
            }
            else if(nodeXs[mid+1].node.y<range.y) {
                left = mid;
            }
            else {
                break;
            }
            mid = (left+right)/2;
        }
        int xEnd = mid;
        left=0; right=nodes.size(); mid=nodes.size()/2;
        while(left<right) {
            if(nodeYs[mid].node.y>range.y) {
                right = mid;
            }
            else if(nodeYs[mid+1].node.y<range.y) {
                left = mid;
            }
            else {
                break;
            }
            mid = (left+right)/2;
        }
        int yEnd = mid;
        System.out.println(xStart + "," + xEnd + "," + yStart + "," + yEnd);
        return null;
    }


    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        //(1, 4), (30, 40), (20, 91), (8, 10), (6, 7), (3, 9), (9, 12), (11, 14)
        list.add(new Node(1, 4));
        list.add(new Node(30, 40));
        list.add(new Node(20, 91));
        list.add(new Node(8, 10));
        list.add(new Node(6, 7));
        list.add(new Node(3, 9));
        list.add(new Node(9, 12));
        list.add(new Node(11, 14));
        getRange(list, new Node(3, 13));
    }
}
