package com.pli.project.algorithm.tree.suffixtree.util;

/**
 * Created by pli on 12/18/2015.
 * This is a record used for lcs search
 */
public class LcsRec {

    public int firstPos;    // position where common string happens in first string
    public int secondPos;   // position where common string happens in first string
    public int length;      // length of common string

    public LcsRec() {
        firstPos = -1;
        secondPos = -1;
        length = 0;
    }

}
