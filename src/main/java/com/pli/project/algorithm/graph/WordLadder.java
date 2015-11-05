package com.pli.project.algorithm.graph;

import java.util.*;

/**
 * Created by lipeng on 2015/11/4.
 */
public class WordLadder {

    public static int getWordLadder(String start, String end, String[] dict) {
        dict = Arrays.copyOf(dict, dict.length+2);
        dict[dict.length-2] = start;
        dict[dict.length-1] = end;
        HashMap<String, Node> graphMap = new HashMap<String, Node>();
        for(String word:dict) {
            Node node = new Node(word);
            graphMap.put(word, node);
        }
        for(String srcWord:dict) {
            for(String destWord:dict) {
                if(isWordConnected(srcWord, destWord)) {
                    Node srcNode = graphMap.get(srcWord);
                    Node destNode = graphMap.get(destWord);
                    srcNode.addNeighbor(destNode, 1);
                    destNode.addNeighbor(srcNode, 1);
                }
            }
        }
        HashSet<Node> grapSet = new HashSet<Node>(graphMap.values());
        return minPathCost(grapSet, graphMap.get(start) , graphMap.get(end));
    }

    //return true if src and dest only has one letter difference
    public static boolean isWordConnected(String src, String dest) {
        if(src==null||dest==null||src.length()!=dest.length()) {
            return false;
        }
        int diff = 0;
        for(int i=0; i<src.length(); i++) {
            if(src.charAt(i)!=dest.charAt(i)) {
                diff++;
            }
            if(diff>1) {
                return false;
            }
        }
        if(diff==1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static class Node{
        public String node;
        HashMap<Node, Integer> neighor = new HashMap<Node, Integer>();

        public Node(String node) {
            this.node = node;
        }

        public void addNeighbor(Node node, int cost) {
            neighor.put(node, cost);
        }

        public boolean equals(Object obj) {
            if(obj==null) {
                return false;
            }
            if(this==obj) {
                return true;
            }
            if(obj instanceof Node) {
                Node objNode = (Node)obj;
                return this.node.equals(objNode.node);
            }
            else {
                return false;
            }
        }
    }

    //calculate min cost from startPoint to endPoint.
    public static int minPathCost(HashSet<Node> graph, Node startPoint, Node endPoint) {
        HashSet<Node> finished = new HashSet<Node>();
        HashMap<Node, Integer> minPathRec = new HashMap<Node, Integer>();   //to record path cost to each node.
        minPathRec.put(startPoint, 0);
        for(int i=0; i<graph.size(); i++) {
            Map.Entry<Node, Integer> minCostNode = null;
            //find the minimum path cost;
            for(Map.Entry<Node, Integer> currNode:minPathRec.entrySet()) {
                if(minCostNode==null) {
                    minCostNode = currNode;
                }
                else if(minCostNode.getValue()>currNode.getValue() && !finished.contains(currNode)){
                    minCostNode = currNode;
                }
            }
            if(minCostNode.getKey()==endPoint) {
                return minCostNode.getValue();
            }
            finished.add(minCostNode.getKey());
            //update minPathRec
            for(Map.Entry<Node, Integer> currNode:minCostNode.getKey().neighor.entrySet()) {
                int currPathCost = minCostNode.getValue() + currNode.getValue();
                if (!finished.contains(currNode.getKey()) && (!minPathRec.containsKey(currNode.getKey()) || currPathCost<minPathRec.get(currNode.getKey()))) {
                    minPathRec.put(currNode.getKey(), currPathCost);
                }
            }
            minPathRec.remove(minCostNode.getKey());
        }
        return -1;
    }

   public static void main(String[] args) {
       String start = "hit";
       String end = "cog";
       String[] dict = {"hot","dot","dog","lot","log"};
       System.out.println(getWordLadder(start, end, dict));
    }
}
