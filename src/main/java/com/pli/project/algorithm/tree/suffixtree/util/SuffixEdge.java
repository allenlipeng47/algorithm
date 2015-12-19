package com.pli.project.algorithm.tree.suffixtree.util;

/**
 * Created by pli on 12/15/2015.
 */
public class SuffixEdge {

    public int start;   // start position of string on edge

    public int end; // -1 means it has no out-going node, it is an end edge

    public int strStart;    // the start point where the whole substring is

    public SuffixNode parent;

    public SuffixNode child;

    public SuffixEdge(SuffixNode parent, int start) {
        this.parent = parent;
        this.start = start;
        end = -1;
    }

}