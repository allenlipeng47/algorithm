package com.pli.project.algorithm.array;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/12/26.
 */
public class SparseMatrix {

    @Data
    public static class Triple {
        int i, j, value;
        public Triple(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        public Triple() {
            this.i = this.j = this.value = 0;
        }
    }

    // Triple tuple matrix
    public static class TSMatrix {
        public int rowNum;  // row length
        public int colNum;  // column length
        public Triple[] datas;
    }

    /* Transpose a sparse matrix. First build num[]. num[i] stores in matrix a, the number of non-zero element in column i.
    col[i] stores in column i, where the first non-zero element should be in new matrix.
    Time complexsity O(tu+col)
    Refer data structure book p99.*/
    public static TSMatrix transpose(TSMatrix a) {
        int[] num = new int[a.colNum];
        int[] col = new int[a.colNum+1];
        for(Triple data:a.datas)
            num[data.j]++;
        for(int i=1; i<col.length; i++)
            col[i] = col[i-1] + num[i-1];
        TSMatrix transpose = new TSMatrix();
        transpose.colNum = a.rowNum;
        transpose.rowNum = a.colNum;
        transpose.datas = new Triple[a.datas.length];
        for(Triple data:a.datas) {
            transpose.datas[col[data.j]] = new Triple(data.j, data.i, data.value);
            col[data.j]++;
        }
        return transpose;
    }

    // data structure p101
    public static TSMatrix multiply(TSMatrix a, TSMatrix b) {
        if(a.colNum !=b.rowNum)  // can't do multiplication if column of a doesn't equal row of b
            return null;
        // build rpos for b. Stores position in datas where each row at
        int[] num = new int[b.rowNum];
        int[] rpos = new int[b.rowNum+1];
        for(Triple data:b.datas)
            num[data.i]++;
        for(int i=1; i<rpos.length; i++)
            rpos[i] = rpos[i-1] + num[i-1];
        List<Triple> tmpResult = new ArrayList<Triple>();
        int p = 0;  // indicate which element it is processing in b.datas[]
        for(int row=0; row<a.rowNum; row++) { // i indicate row
            int[] tmp = new int[b.colNum];
            while (p<a.datas.length && a.datas[p].i==row) {
                int rowB = a.datas[p].j;
                for(int j=rpos[rowB]; j<rpos[rowB+1]; j++)
                    tmp[b.datas[j].j] += a.datas[p].value * b.datas[j].value;
                p++;
            }
            for(int i=0 ; i<tmp.length; i++) {
                if(tmp[i]!=0)
                    tmpResult.add(new Triple(row, i, tmp[i]));
            }
        }
        TSMatrix result = new TSMatrix();
        result.rowNum = a.rowNum;
        result.colNum = b.colNum;
        result.datas = tmpResult.toArray(new Triple[tmpResult.size()]);
        return result;
    }

    public static void main(String[] args) {
        testTranspose();
//        testMultiplication();
    }

    public static void testTranspose() {
        TSMatrix matrix = new TSMatrix();
        matrix.rowNum = 6;
        matrix.colNum = 7;
        matrix.datas = new Triple[8];
        matrix.datas[0] = new Triple(0, 1, 12);
        matrix.datas[1] = new Triple(0, 2, 9);
        matrix.datas[2] = new Triple(2, 0, -3);
        matrix.datas[3] = new Triple(2, 5, 14);
        matrix.datas[4] = new Triple(3, 2, 24);
        matrix.datas[5] = new Triple(4, 1, 18);
        matrix.datas[6] = new Triple(5, 0, 15);
        matrix.datas[7] = new Triple(5, 3, -7);
        TSMatrix transpose = transpose(matrix);
        System.out.println();
    }

    public static void testMultiplication() {
        TSMatrix a = new TSMatrix();
        a.rowNum = 3;
        a.colNum = 4;
        a.datas = new Triple[4];
        a.datas[0] = new Triple(0, 0, 3);
        a.datas[1] = new Triple(0, 3, 5);
        a.datas[2] = new Triple(1, 1, -1);
        a.datas[3] = new Triple(2, 0, 2);
        TSMatrix b = new TSMatrix();
        b.rowNum = 4;
        b.colNum = 2;
        b.datas = new Triple[4];
        b.datas[0] = new Triple(0, 1, 2);  // empty element
        b.datas[1] = new Triple(1, 0, 1);
        b.datas[2] = new Triple(2, 0, -2);
        b.datas[3] = new Triple(2, 1, 4);
        TSMatrix c = multiply(a, b);
        System.out.println();
    }

    public static void testMultiplication1() {
        TSMatrix a = new TSMatrix();
        a.rowNum = 3;
        a.colNum = 4;
        a.datas = new Triple[6];
        a.datas[0] = new Triple(1, 1, 3);
        a.datas[1] = new Triple(1, 2, 5);
        a.datas[2] = new Triple(1, 3, -1);
        a.datas[3] = new Triple(2, 0, -1);
        a.datas[4] = new Triple(2, 1, -1);
        a.datas[5] = new Triple(2, 2, -1);
        TSMatrix b = new TSMatrix();
        b.rowNum = 4;
        b.colNum = 3;
        b.datas = new Triple[4];
        b.datas[0] = new Triple(0, 0, 0);  // empty element
        b.datas[1] = new Triple(1, 2, 2);
        b.datas[2] = new Triple(1, 1, 1);
        b.datas[3] = new Triple(3, 1, -2);
        TSMatrix c = multiply(a, b);
        System.out.println();
    }
}
