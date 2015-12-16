package com.pli.project.algorithm.tree.suffixtree;

import com.pli.project.algorithm.tree.suffixtree.util.ActivePoint;
import com.pli.project.algorithm.tree.suffixtree.util.SuffixEdge;
import com.pli.project.algorithm.tree.suffixtree.util.SuffixNode;

/**
 * Created by lipeng on 2015/12/12.
 * Online suffix tree check: http://www.allisons.org/ll/AlgDS/Tree/Suffix/
 */
public class SuffixTree {

    public static final int CHARARCTER_SIZE = 256;

    public String str;

    public SuffixNode root;

    public SuffixTree(String str) {
        this.str = str;
        build(str);
        updateEdgePos();
    }

    private SuffixNode build(String str) {
        root = new SuffixNode();
        SuffixNode preInternalNode = null;
        ActivePoint activePoint = new ActivePoint(root);
        int remaining = 0;
        for(int i=0; i<str.length(); i++) {
            remaining++;
            preInternalNode = null; // suffix link only link to each internal node in same phase. Reset at the beginning of each phase.
            while (remaining>0) {
                if(activePoint.activeLength==0) {   // check root
                    char ch = str.charAt(i);
                    if(root.edges[ch-'0']==null) {
                        SuffixEdge edge = new SuffixEdge(root, i);
                        root.addEdge(str.charAt(i), edge);
                        remaining = 0;
                        preInternalNode = null;
                    }
                    else {
                        activePoint.activeLength = 1;
                        activePoint.activeEdge = root.edges[ch-'0'].start;
                    }
                    break;
                }
                SuffixEdge activeEdge = activePoint.activePoint.edges[str.charAt(activePoint.activeEdge) - '0'];
                if (isNextValid(activePoint, str.charAt(i))) {
                    if (activeEdge.end==-1 || activeEdge.start+activePoint.activeLength<=activeEdge.end) {
                        activePoint.activeLength++; //next position is in edge
                    } else {
                        // it is the end of edge, activeNode moves to child node point
                        activePoint.activePoint = activeEdge.child;
                        activePoint.activeEdge = activePoint.activePoint.edges[str.charAt(i)-'0'].start;
                        activePoint.activeLength = 1;
                    }
                    break;  //if match, then go to next i
                }
                // not able to find str.charAt(i) in next position of active point, should split
                SuffixNode internalNode = split(activePoint, i); // this is the splitted node generated
                if (activePoint.activePoint == root) {   //
                    activePoint.activeEdge++;
                    activePoint.activeLength--;
                } else {
                    activePoint.activePoint = activePoint.activePoint.suffixLink;
                }
                if(activePoint.activePoint==root)
                    activePoint = activePoint.updateActivePoint(activePoint, str);  //update active Point

                //update preSuffixNode
                internalNode.suffixLink = root;
                if (preInternalNode != null) {
                    preInternalNode.suffixLink = internalNode;
                    preInternalNode = internalNode;
                    internalNode.suffixLink = root;
                }
                else {
                    preInternalNode = internalNode;
                }
                remaining--;    // created a new internal node, decrease remaining
            }
        }
        return root;
    }

    private SuffixNode updateEdgePos() {
        for(SuffixEdge edge:root.edges) {
            if(edge!=null)
                updateEdgePosHelper(edge, 0);
        }
        return root;
    }

    private void updateEdgePosHelper(SuffixEdge edge, int total) {
        edge.strStart = edge.start - total;
        if(edge.child==null)
            return;
        for(SuffixEdge currEdge:edge.child.edges) {
            if(currEdge!=null)
                updateEdgePosHelper(currEdge, total+edge.end-edge.start+1);
        }
    }

    // split the edge, add an internal node at position i in edge
    public SuffixNode split(ActivePoint activePoint, int i) {
        SuffixEdge activeEdge = activePoint.activePoint.edges[str.charAt(activePoint.activeEdge)-'0'];
        int splitPos = activeEdge.start + activePoint.activeLength; // the position where the edge should be splitted
        // at the end position of edge, should add new edge under edge's child
        if(splitPos==activeEdge.end+1) {    // split scenario 3
            activeEdge.child.addEdge(str.charAt(i), new SuffixEdge(activeEdge.child, i));
            return activeEdge.parent;
        }
        //1. create the internal node
        SuffixNode newNode = new SuffixNode();
        SuffixEdge newEdge = new SuffixEdge(newNode, i);
        newNode.addEdge(str.charAt(i), newEdge);
        //active point hasn't reach end of edge. should split the edge.
        if(activeEdge.end!=-1) {    // split scenario 2
            SuffixEdge middleEdge = new SuffixEdge(newNode, splitPos);
            middleEdge.end = activeEdge.end;
            middleEdge.child = activeEdge.child;
            newNode.addEdge(str.charAt(splitPos), middleEdge);
        }
        else {  // split scenario 1
            SuffixEdge continueEdge = new SuffixEdge(newNode, splitPos);
            newNode.addEdge(str.charAt(splitPos), continueEdge);
        }
        activeEdge.child = newNode;
        activeEdge.end = splitPos-1;
        return newNode;
    }

    // check if next position of activePoint matche ch
    private boolean isNextValid(ActivePoint activePoint, char ch) {
        SuffixEdge edge = activePoint.activePoint.edges[str.charAt(activePoint.activeEdge)-'0'];
        if(edge.start+activePoint.activeLength<=edge.end || edge.end==-1) { // can still check at edge
            return str.charAt(edge.start+activePoint.activeLength)==ch ? true : false;
        }
        else {
            return edge.child.edges[ch-'0']==null ? false : true;   // in edge's child node
        }
    }

    public int match(String t) {
        if(t==null||t.length()<1)
            return -1;
        SuffixEdge edge = root.edges[t.charAt(0)-'0'];
        if(edge==null)
            return -1;
        int len = 1;
        for(int i=0; i<t.length(); i++) {
            if(edge==null || edge.start+len-1>=str.length() || str.charAt(edge.start+len-1)!=t.charAt(i))
                return -1;
            if(edge.start+len==edge.end+1 && edge.end!=-1 && i+1<t.length()) { // can still check at edge
                edge = edge.child.edges[t.charAt(i+1)-'0'];
                len = 1;
            }
            else {
                len++;
            }
        }
        return edge.strStart;
    }

    public static void main(String[] args) {
        String str = "xyzxyaxyz";
//        str = "mississi";
//        String str = "mississippi";
        SuffixTree tree = new SuffixTree(str);
        System.out.println(tree.match("axyz"));
    }

    public static void test11() {
        String str = "01234567890123456";
        SuffixNode node = new SuffixNode();
        SuffixEdge edge = new SuffixEdge(node, 'a');
        SuffixNode childNode = new SuffixNode();
        edge.child = childNode;
        edge.child.addEdge('4', new SuffixEdge(childNode, 4) );
        edge.start = 3;
        edge.end = -1;
//        SuffixEdge newEdge = split(edge, 2, 9);
    }

    public static void test2() {
        String str = "abcdefghifklmnopq";
        SuffixNode node = new SuffixNode();
        SuffixEdge edge = new SuffixEdge(node, 3);
        edge.end = 5;
        node.addEdge(str.charAt(3), edge);
        // sub edge
        SuffixNode subNode = new SuffixNode();
        SuffixEdge subEdge = new SuffixEdge(subNode, 9);
        subNode.addEdge(str.charAt(9), subEdge);
        edge.child = subNode;
        ActivePoint activePoint = new ActivePoint(node, 3, 4);
//        System.out.println(SuffixTree.search(activePoint, 'f'));
    }

    public static void testEdgeMove() {
        String str = "mississi$";
        SuffixTree tree = new SuffixTree("mississi$");
        SuffixNode root = new SuffixNode();
        SuffixNode l = new SuffixNode();
        SuffixEdge e1 = new SuffixEdge(root, 0);
        SuffixEdge e2 = new SuffixEdge(root, 1);
        SuffixEdge e3 = new SuffixEdge(root, 2); e3.end = 2;
        SuffixEdge e4 = new SuffixEdge(l, 4);
        SuffixEdge e5 = new SuffixEdge(l, 3);
        e3.child = l;
        root.addEdge(str.charAt(0), e1);
        root.addEdge(str.charAt(1), e2);
        root.addEdge(str.charAt(2), e3);
        l.addEdge(str.charAt(4), e4);
        l.addEdge(str.charAt(3), e5);
        ActivePoint point = new ActivePoint(root, 2, 1);
        point = point.updateActivePoint(point, str);
        System.out.println();
    }

}
