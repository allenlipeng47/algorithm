package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2015/12/10.
 */
public class junmin {

    public static class Trie{
        boolean isWord;
        Trie[] children = new Trie[256];

        /*
         * return every node's children
         * if not found return null
         */
        Trie getChildrenAt(char c){
            return children[c];
        }
    }



    public static void findWords(char[][] board){
		/*
		* first build the trie for the dictionary of words
		* here i skip it
		*/
        Trie root = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int r=0; r< board.length; r++)
            for(int c=0; c<board[0].length; c++)
                findWordsRec(board, visited, root, r, c);
    }

    /*
    * essentially it is done by depth first search for every position
    */
    private static void findWordsRec(char[][] board, boolean[][] visited, Trie current, int row, int col){
        int length = board.length;
        int lengthC = board[0].length;
		/*
		* deal with all possible exit conditions first
		*/
        if(row<0 || col<0 || row>=length || col>=lengthC)
            return;

        if(visited[row][col])
            return;

        if(current==null)
            return;

        if(current.isWord){
            System.out.println("found one at " + row +  " - " + col);
            return;
        }
        //make copy of original visited
        //then set row col to true
        boolean[][] copy = new boolean[length][lengthC];
        for(int r=0; r< length; r++)
            for(int c=0; c<lengthC; c++)
                copy[r][c] = visited[r][c];

        copy[row][col] = true;

        Trie next = current.getChildrenAt(board[row][col]);
        findWordsRec(board, copy, next, row+1, col);
        findWordsRec(board, copy, next, row-1, col);
        findWordsRec(board, copy, next, row, col-1);
        findWordsRec(board, copy, next, row, col+1);
    }

    public static void main(String[] args) {
        char[][] board = {
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
            };
        String[] words = {"oath","pea","eat","rain"};
        findWords(board);

    }
}
