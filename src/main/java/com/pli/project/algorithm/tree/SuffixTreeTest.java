package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import org.omg.PortableInterceptor.ACTIVE;

/**
 * Created by lipeng on 2015/12/12.
 * Online suffix tree check: http://www.allisons.org/ll/AlgDS/Tree/Suffix/
 */
public class SuffixTreeTest {

    public static final int CHARARCTER_SIZE = 256;

    public static String str;

    public static SuffixNode root;

    public static class SuffixNode {
        public SuffixEdge[] edges = new SuffixEdge[CHARARCTER_SIZE];
        public SuffixNode suffixLink;

        public void addEdge(char c, SuffixEdge edge) {
            edges[c-'0'] = edge;
        }
    }

    public static SuffixNode build(String str) {
        root = new SuffixNode();
        SuffixNode preInternalNode = null;
        ActivePoint activePoint = new ActivePoint();
        SuffixNode preActivePoint = null;
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
                if (search(activePoint, str.charAt(i))) {
                    if (activeEdge.end==-1 || activeEdge.start+activePoint.activeLength<=activeEdge.end) {
                        activePoint.activeLength++; //next position is in edge
                    } else {
                        // it is the end of edge, activeNode moves to child node point
                        preActivePoint = activePoint.activePoint;
                        activePoint.activePoint = activeEdge.child;
                        activePoint.activeEdge = activePoint.activePoint.edges[str.charAt(i)-'0'].start;
//                        activePoint.activePoint.edges[str.charAt(i)-'0'].start;
                        activePoint.activeLength = 1;
                        //edge.child.edges[ch-'0']==null ? false : true;
                    }
                    break;  //if match, then go to next i
                }
                // not able to find str.charAt(i) in next position of active point, should split
                SuffixNode internalNode = split(activePoint, i); // this is the splitted node generated
//                if(activePoint.activePoint==root && preActivePoint!=root && preActivePoint!=null) { // if pre is root and current active point is root, then we do nothing. Or we change activePoint. See video 41:47
//                    preActivePoint = root;
//                }
//                else {
                    if (activePoint.activePoint == root) {   //
                        activePoint.activeEdge++;
                        activePoint.activeLength--;
                        if(activePoint.activeLength>0)
                            activePoint = activePoint.updateActivePoint(activePoint, str);  //update active Point
                    } else {
                        preActivePoint = activePoint.activePoint;
                        activePoint.activePoint = activePoint.activePoint.suffixLink;
                    }
//                }
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

    public static class SuffixEdge {

        public int start;

        public int end; // -1 means it has no out-going node, it is an end edge

        public SuffixNode parent;

        public SuffixNode child;

        public SuffixEdge(SuffixNode parent, int start) {
            this.parent = parent;
            this.start = start;
            end = -1;
        }

    }

    // split the edge, add an internal node at position i in edge
    public static SuffixNode split(ActivePoint activePoint, int i) {
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
    public static boolean search(ActivePoint activePoint, char ch) {
        SuffixEdge edge = activePoint.activePoint.edges[str.charAt(activePoint.activeEdge)-'0'];
        if(edge.start+activePoint.activeLength<=edge.end || edge.end==-1) { // can still check at edge
            return str.charAt(edge.start+activePoint.activeLength)==ch ? true : false;
        }
        else {
            return edge.child.edges[ch-'0']==null ? false : true;   // in edge's child node
        }
    }

    public static class ActivePoint {
        public SuffixNode activePoint;
        public int activeEdge;
        public int activeLength;
        public ActivePoint(SuffixNode activePoint, int activeEdge, int activeLength) {
            this.activePoint = activePoint;
            this.activeEdge = activeEdge;
            this.activeLength = activeLength;
        }

        public ActivePoint() {
            reset();
        }

        public void reset() {
            activePoint = root;
            activeEdge = -1;
            activeLength = 0;
        }

        // when a internal node is created and active point is root,
        public ActivePoint updateActivePoint(ActivePoint point, String str) {
            int newLength = 0;
            SuffixEdge edge = point.activePoint.edges[str.charAt(point.activeEdge)-'0'];
            for(int i=0, pos=point.activeEdge; i<point.activeLength; i++, pos++) {
                if(edge.end==-1 || newLength <= edge.end-edge.start)
                    newLength++;
                else {
                    edge = edge.child.edges[str.charAt(pos)-'0'];
                    point.activeEdge = edge.start;
                    point.activePoint = edge.parent;
                    newLength = 1;
                }
            }
            point.activeLength = newLength;
            return point;
        }
    }

    public static void main(String[] args) {
//        str = "xyzxyaxyz|";
        str = "mississi|";
        SuffixNode node = build(str);
        System.out.println();
    }

    public static void test11() {
        SuffixNode node = new SuffixNode();
        SuffixEdge edge = new SuffixEdge(node, 'a');
        SuffixNode childNode = new SuffixNode();
        edge.child = childNode;
        edge.child.addEdge('4', new SuffixEdge(childNode, 4) );
        edge.start = 3;
        edge.end = -1;
        str = "01234567890123456";
//        SuffixEdge newEdge = split(edge, 2, 9);
    }

    public static void test2() {
        str = "abcdefghifklmnopq";
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
        System.out.println(search(activePoint, 'f'));
    }

    public static void testEdgeMove() {
        str = "mississi$";
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
