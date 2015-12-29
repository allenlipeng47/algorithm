package com.pli.project.algorithm.array.suffixarray;

/**
 * Created by pli on 12/29/2015.
 * Suffix must have length(), charAt() and compareTo functions
 */
public class Suffix implements Comparable<Suffix> {
    final public String str;
    final public int index;
    public Suffix(String str, int index) {
        this.str = str;
        this.index = index;
    }

    public char charAt(int i) {
        if(i<0 || i>=str.length()-index)
            throw new IndexOutOfBoundsException(i + " is not a legal position for suffix " + this);
        return str.charAt(index+i);
    }

    public int compareTo(Suffix that) {
        if(this==that)
            return 0;
        int N = Math.min(this.length(), that.length());
        for(int i=0; i<N; i++) {
            if(this.charAt(i)>that.charAt(i))
                return 1;
            if(this.charAt(i)<that.charAt(i))
                return -1;
        }
        return this.length() - that.length();
    }

    public int length() {
        return str.length() - index;
    }

    public String toString() {
        return str.substring(index);
    }
}