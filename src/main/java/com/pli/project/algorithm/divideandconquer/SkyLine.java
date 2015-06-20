package com.pli.project.algorithm.divideandconquer;

/**
 * Created by lipeng on 2015/6/19.
 */
public class SkyLine {

    /** The next of last node in firstHalf is successor **/
    public static PointList skyLine(PointList firstHalf){
        if(firstHalf==null||firstHalf.next==null||firstHalf.next.next==null){
            return firstHalf;
        }
        PointList slow = firstHalf, fast = firstHalf;
        int moveCount = 0;
        while(fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            moveCount++;
        }
        if(moveCount % 2 ==0){
            slow = slow.next;
        }
        PointList secondHalf = slow.next;
        slow.next = null;   //cut firstHalf and secondHalf;
        slow = null; fast = null;   //release unused reference
        firstHalf = skyLine(firstHalf);
        secondHalf = skyLine(secondHalf);
        /** start to merge firstHalf and secondHalf list **/
        int firstHeight = 0, secondHeight = 0;
        PointList fakeMergeHead = new PointList(0, 0);
        PointList curr = fakeMergeHead;
        while( firstHalf!=null && secondHalf!=null){
            if(firstHalf.x < secondHalf.x){
                firstHeight = firstHalf.y;
                firstHalf.y = Math.max(firstHalf.y, secondHeight);
                curr.next = firstHalf;
                firstHalf = firstHalf.next;
            }
            else{
                secondHeight = secondHalf.y;
                secondHalf.y = Math.max(secondHalf.y, firstHeight);
                curr.next = secondHalf;
                secondHalf = secondHalf.next;
            } //if
            curr = curr.next;
            curr.next = null;
        } //while
        curr.next = firstHalf==null ? secondHalf : firstHalf;
        PointList head = fakeMergeHead.next;
        fakeMergeHead = null;
        /** Eliminate unnecessary points **/
        curr = head;
        while(curr.next!=null){
            if(curr.y!=curr.next.y){
                curr = curr.next;
            }
            else{
                PointList tmp = curr.next;
                curr.next = tmp.next;
                tmp = null;
            } //if
        } //while
        return head;
    }

}
