package com.pli.project.algorithm.graph;

import java.util.*;

/**
 * Created by lipeng on 2015/11/4.
 */
public class Dijkstra {

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
                return this.node==objNode.node;
            }
            else {
                return false;
            }
        }
    }

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
       Node v0 = new Node("v0");
       Node v1 = new Node("v1");
       Node v2 = new Node("v2");
       Node v3 = new Node("v3");
       Node v4 = new Node("v4");
       Node v5 = new Node("v5");
       v0.addNeighbor(v5, 100); v0.addNeighbor(v4, 30); v0.addNeighbor(v2, 10);
       v1.addNeighbor(v2, 5);
       v2.addNeighbor(v3, 50);
       v3.addNeighbor(v5, 10);
       v4.addNeighbor(v5, 60); v4.addNeighbor(v3, 20);
       HashSet<Node> graph = new HashSet<Node>();
       graph.add(v0);
       graph.add(v1);
       graph.add(v2);
       graph.add(v3);
       graph.add(v4);
       graph.add(v5);
       System.out.println(minPathCost(graph, v0, v5));
    }
}
