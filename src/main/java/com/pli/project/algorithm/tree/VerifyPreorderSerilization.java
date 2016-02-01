package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/31.
 */
public class VerifyPreorderSerilization {

    public static boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        int[] pos = new int[] {-1};
        if (!validHelper(list, pos) || pos[0] != list.length - 1) { // in the end, pos[0] should equal len - 1
            return false;
        }
        return true;
    }

    public static boolean validHelper(String[] list, int[] pos) {
        pos[0]++;
        if (pos[0] >= list.length) {  // add pos[0] first
            return false;
        }
        if (list[pos[0]].equals("#")) { // if is '#', return true.
            return true;
        }
        // if is a number, call 2 times.
        return validHelper(list, pos) && validHelper(list, pos);
    }

    public static boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }


    public static void main(String[] args) {
//        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String preorder = "9,3,#,#,#";
//        String preorder = "1,#";
        String preorder = "9,#,#";
        System.out.println(isValidSerialization(preorder));
    }

}
