package com.pli.project.algorithm.ms;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/3/19.
 */
public class SimplyPath {

    public String simplifyPath(String path) {
        String[] strs = path.substring(1, path.length()).split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (String str : strs) {
            if (str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            }
            else if (!str.equals("")){
                queue.add(str);
            }
        }
        StringBuffer sb = new StringBuffer("/");
        while (!queue.isEmpty()) {
            sb.append(queue.removeFirst() + "/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String path = "/home/";
//        String path = "/a/./b/../../c/";
//        String path = "/abc/...";
        String path = "///";
        SimplyPath s = new SimplyPath();
        System.out.println(s.simplifyPath(path));
    }


}
