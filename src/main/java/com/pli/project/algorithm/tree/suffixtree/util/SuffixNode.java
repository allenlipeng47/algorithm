package com.pli.project.algorithm.tree.suffixtree.util;

/**
 * Created by pli on 12/14/2015.
 */
public class SuffixNode {

    public static final int CHARARCTER_SIZE = 256;

    public SuffixEdge[] edges = new SuffixEdge[CHARARCTER_SIZE];
    public SuffixNode suffixLink;

    public void addEdge(char c, SuffixEdge edge) {
        edges[c-'0'] = edge;
    }
}
