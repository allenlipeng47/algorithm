package com.pli.project.algorithm.divideandconquer;

/**
 * Created by lipeng on 2015/6/20.
 */
public class PointList {
    public int x,y;
    public PointList next;
    public PointList(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        if(this.next!=null){
            return "(" + x + "," + y + "), " + this.next.toString();
        }
        else {
            return "(" + x + "," + y + ")\r\n";
        }
    }
}