package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.Tree;
import org.junit.Assert;

import java.util.*;

/**
 * Created by lipeng on 2015/7/21.
 */
public class VerticalPrint {

    static class VerticalInfo{
        public int min;
        public int max;
        public Map<Integer, List<Tree>> hm = new HashMap<Integer, List<Tree>>();
    }

    private static void getMaxMin(Tree tree, VerticalInfo info, int currLevel){
        if(tree == null){
            return;
        }
        if(currLevel < info.min){
            info.min = currLevel;
        }
        if(currLevel > info.max){
            info.max = currLevel;
        }
        if(info.hm.get(currLevel)==null){
            List<Tree> list = new ArrayList<Tree>();
            list.add(tree);
            info.hm.put(currLevel, list);
        }
        else {
            info.hm.get(currLevel).add(tree);
        }
        getMaxMin(tree.left, info, currLevel - 1);
        getMaxMin(tree.right, info, currLevel + 1);
    }

    /* Vertical print. During the traversal, store the result to each level.
     * Time complexity O(n). Space complexity O(n) */
    public static void verticalPrint(Tree tree){
        Assert.assertNotNull(tree);
        VerticalInfo info = new VerticalInfo();
        getMaxMin(tree, info, 0);
        for(int level=info.min; level <= info.max; level++){
            List<Tree> list = info.hm.get(level);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static void getMaxMin2(Tree tree, VerticalInfo info, int currLevel){
        if(tree == null){
            return;
        }
        if(currLevel < info.min){
            info.min = currLevel;
        }
        if(currLevel > info.max){
            info.max = currLevel;
        }
        getMaxMin2(tree.left, info, currLevel - 1);
        getMaxMin2(tree.right, info, currLevel+1);
    }

    public static void verticalPrint2Printer(Tree tree, int targetLevel, int currLevel){
        if(tree==null){
            return;
        }
        if(targetLevel==currLevel){
            System.out.println(tree);
        }
        verticalPrint2Printer(tree.left, targetLevel, currLevel-1);
        verticalPrint2Printer(tree.right, targetLevel, currLevel+1);
    }

    /* Only find min and max level. After that, loop printer from min to max.
    * In each loop, only print the tree val where it is in current level.
     * Time complexity O(d^n). d=max-min. Space complexity O(1)*/
    public static void verticalPrint2(Tree tree){
        Assert.assertNotNull(tree);
        VerticalInfo info = new VerticalInfo();
        getMaxMin2(tree, info, 0);
        for(int targetLevel=info.min; targetLevel <= info.max; targetLevel++){
            verticalPrint2Printer(tree, targetLevel, 0);
        }
    }

    public static void main(String[] args) {
        Tree tree = Tree.getTree();
        verticalPrint(tree);
        verticalPrint2(tree);
    }

}