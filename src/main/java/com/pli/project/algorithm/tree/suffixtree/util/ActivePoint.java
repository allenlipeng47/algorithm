package com.pli.project.algorithm.tree.suffixtree.util;

import com.pli.project.algorithm.tree.suffixtree.util.*;

/**
 * Created by pli on 12/15/2015.
 */
public class ActivePoint {
    public SuffixNode activePoint;
    public int activeEdge;
    public int activeLength;
    public ActivePoint(SuffixNode activePoint, int activeEdge, int activeLength) {
        this.activePoint = activePoint;
        this.activeEdge = activeEdge;
        this.activeLength = activeLength;
    }

    public ActivePoint(SuffixNode root) {
        reset(root);
    }

    public void reset(SuffixNode root) {
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