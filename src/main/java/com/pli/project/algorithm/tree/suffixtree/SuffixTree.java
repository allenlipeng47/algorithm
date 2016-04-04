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

    public int str2ndPos; // the position of the second word

    public SuffixTree(String str) {
        this.str = str + "|";   // we don't add the terminal, suffix tree won't pass for "ATCGATCGA"
        build(this.str);
        updateEdgePos();
    }

    public SuffixTree(String str1, String str2) {
        this.str = str1 + "{" + str2 + "}";
        build(str);
        updateEdgePos();
        str2ndPos = str1.length()+1;
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

    public int indexOf(String t) {
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

    public String lcs() {
        LcsRec result = null;
        for(SuffixEdge edge:root.edges) {
            if(edge==null)
                continue;
            LcsRec curRec = lcsHelper(edge);
            if((result==null&&curRec.len>0) || (result!=null&&curRec.len>result.len))
                result = curRec;
        }
        if(result==null)
            return "";
//        System.out.println(str);
//        System.out.println("Lcs at first string: " + result.firstPos + ", second string: " + result.secondPos);
        return str.substring(result.firstPos, result.firstPos+result.len);
    }

    public LcsRec lcsHelper(SuffixEdge edge) {
        if(edge.child==null) {
            if(edge.start< str2ndPos)
                return new LcsRec(edge.strStart, -1, 0);
            else
                return new LcsRec(-1, edge.strStart, 0);
        }
        LcsRec resultRec = null;
        int firstPos=-1, secondPos=-1;
        for(SuffixEdge currEdge:edge.child.edges) {
            if(currEdge==null)
                continue;
            LcsRec currRec = lcsHelper(currEdge);
            if((resultRec==null&&currRec.len>0) || resultRec!=null&&resultRec.len<currRec.len)
                resultRec = currRec;
            else if(currRec.firstPos>=0)
                firstPos = currRec.firstPos;
            else
                secondPos = currRec.secondPos;
            currRec = null; // release the unused reference. For garbage collection.
        }
        if(resultRec!=null)
            return resultRec;
        else if(firstPos>=0 && secondPos>=0)
            return new LcsRec(firstPos, secondPos, edge.end-edge.strStart+1);
        else if(firstPos>=0)
            return new LcsRec(firstPos, -1, 0);
        else
            return new LcsRec(-1, secondPos, 0);
    }

    public String lrs() {
        LrsRec result = null;
        for(SuffixEdge edge:root.edges) {
            if(edge==null)
                continue;
            LrsRec curRec = lrsHelper(edge);
            if(curRec==null)
                continue;
            if((result==null&&curRec.len>0) || (result!=null&&curRec.len>result.len))
                result = curRec;
        }
        if(result==null)
            return "";
        // if want to return all lrs positions, print result.edge.child.edges[]
        return str.substring(result.startPos, result.startPos+result.len);
    }

    public LrsRec lrsHelper(SuffixEdge edge) {
        if(edge.child==null)
            return null;    // child edge, return null
        LrsRec resultRec = null;
        for(SuffixEdge currEdge:edge.child.edges) {
            if(currEdge==null)
                continue;
            LrsRec currRec = lrsHelper(currEdge);
            if(currRec==null)
                continue;
            if((resultRec==null&&currRec.len>0) || resultRec!=null&&resultRec.len<currRec.len)
                resultRec = currRec;
            currRec = null; // release the unused reference. For garbage collection.
        }
        if(resultRec!=null)
            return resultRec;
        return new LrsRec(edge.strStart, edge.end-edge.strStart+1, edge);
    }

    // when finding the lcs, this structure is used to return the result.
    private class LcsRec {
        public int firstPos;    // position of longest common substring in first string.
        public int secondPos;   // position of longest common substring in second string.
        public int len; // length of longest common substring

        public LcsRec() {
            firstPos = -1;
            secondPos = -1;
            len = 0;
        }

        public LcsRec(int firstPos, int secondPos, int len) {
            this.firstPos = firstPos;
            this.secondPos = secondPos;
            this.len = len;
        }
    }

    // the helper class for longest repeated substrig
    private class LrsRec {

        public int startPos;
        public int len;
        public SuffixEdge edge;

        public LrsRec() {
            startPos = -1;
            len = -1;
        }

        public LrsRec(int startPos, int len, SuffixEdge edge) {
            this.startPos = startPos;
            this.len = len;
            this.edge = edge;
        }

    }

    public static String longestPalindrome(String str) {
        SuffixTree tree = new SuffixTree(str, new StringBuilder(str).reverse().toString());
        return tree.lcs();
    }

    public static void main(String[] args) {
        // find the position of substring
        SuffixTree tree1 = new SuffixTree("mississippi");
        System.out.println(tree1.indexOf("sipp"));

        // find the longest common substring
        SuffixTree tree2 = new SuffixTree("ABCBA", "BABCA");
        System.out.println(tree2.lcs());

        // find the longest palindrome in a string
        System.out.println(longestPalindrome("abaccddccefe"));

        // find the longest repeated substring
        SuffixTree tree3 = new SuffixTree("abbabba");
        System.out.println(tree3.lrs());
    }

}