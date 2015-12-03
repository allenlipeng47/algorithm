package com.pli.project.algorithm.dp;

import java.util.ArrayList;

/**
 * Created by lipeng on 2015/12/2.
 * Given a dictionary, and a string, find all possibilities of breakdown the string
 * For example, dict = [cat, cats, and, dog, sand], str='catsanddog'
 * Should return 'cat sand dog', 'cats and dog'
 */
public class WordBreak {

    public static class WordItem {
        public ArrayList<ArrayList<String>> list;
        public WordItem() {
            list = new ArrayList<ArrayList<String>>();
        }
    }

    public static ArrayList<ArrayList<String>> wordBreak(String[] dict, String str) {
        assert dict!=null && dict.length>0 && str!=null && str.length()>0;
        WordItem[] items = new WordItem[str.length()+1];
        for(int i=0; i<items.length; i++)
            items[i] = new WordItem();
        items[0].list.add(new ArrayList<String>()); //initial items[0], make it not empty
        items[0].list.get(0).add(null);
        for(int i=1; i<str.length(); i++) {
            if(i!=1 && items[i-1].list.isEmpty()) {
                continue;
            }
            for(String word:dict) {
                if(i+word.length()>items.length) {
                    continue;
                }
                // is valid, then update next WordItem
                if(str.substring(i-1, i+word.length()-1).equals(word)) {
                    for(ArrayList<String> strItem:items[i-1].list) {
                        ArrayList<String> curr = new ArrayList<String>(strItem);
                        curr.add(word);
                        curr.remove(null);
                        items[i+word.length()-1].list.add(curr);
                    }
                }
            }// for
        }
        return items[items.length-1].list;
    }

    public static void main(String[] args) {
        String[] dict = {"cat", "cats", "and", "dog", "sand"};
        String str = "catsanddog";
        System.out.println(wordBreak(dict, str));
    }

}
