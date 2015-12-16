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
        int pos = point.activeEdge;
        SuffixEdge edge = point.activePoint.edges[str.charAt(pos)-'0'];
        while (true) {
            if(edge.end==-1 || point.activeLength<=edge.end-edge.start+1)
                return point;
            point.activeLength -= edge.end - edge.start + 1;
            pos = pos + edge.end - edge.start + 1;
            edge = edge.child.edges[str.charAt(pos)-'0'];
            point.activePoint = edge.parent;
            point.activeEdge = edge.start;
        }
    }


}