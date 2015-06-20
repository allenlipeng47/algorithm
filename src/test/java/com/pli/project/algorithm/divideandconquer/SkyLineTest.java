package com.pli.project.algorithm.divideandconquer;

import org.junit.Test;
import static org.junit.Assert.*;
import com.pli.project.algorithm.divideandconquer.SkyLine;

/**
 * Created by lipeng on 2015/6/20.
 */
public class SkyLineTest {

    @Test
    public void  test1(){
        PointList p11 = new PointList(1, 2);
        PointList p12 = new PointList(4, 0);
        PointList p21 = new PointList(2, 2);
        PointList p22 = new PointList(6, 0);
        PointList p31 = new PointList(2, 3);
        PointList p32 = new PointList(4, 0);
        PointList p41 = new PointList(3, 4);
        PointList p42 = new PointList(5, 0);
        PointList p51 = new PointList(4, 1);
        PointList p52 = new PointList(7, 0);
        p11.next = p12; p12.next = p21;
        p21.next = p22; p22.next = p31;
        p31.next = p32; p32.next = p41;
        p41.next = p42; p42.next = p51;
        p51.next = p52; p52.next = null;
        PointList newList = SkyLine.skyLine(p11);
        assertEquals("(1,2), (2,3), (3,4), (5,2), (6,1), (7,0)\r\n", newList.toString());
    }

    @Test
    public void test2(){
        PointList p11 = new PointList(5, 4);
        PointList p12 = new PointList(7, 0);
        PointList p21 = new PointList(1, 1);
        PointList p22 = new PointList(4, 0);
        PointList p31 = new PointList(3, 3);
        PointList p32 = new PointList(6, 0);
        PointList p41 = new PointList(2, 2);
        PointList p42 = new PointList(8, 0);
        p11.next = p12; p12.next = p21;
        p21.next = p22; p22.next = p31;
        p31.next = p32; p32.next = p41;
        p41.next = p42; p42.next = null;
        PointList newList = SkyLine.skyLine(p11);
        assertEquals("(1,1), (2,2), (3,3), (5,4), (7,2), (8,0)\r\n", newList.toString());
    }

    @Test
    public void test3(){
        PointList p11 = new PointList(1, 1);
        PointList p12 = new PointList(2, 0);
        PointList p21 = new PointList(2, 1);
        PointList p22 = new PointList(3, 0);
        p11.next = p12; p12.next = p21;
        p21.next = p22; p22.next = null;
        PointList newList = SkyLine.skyLine(p11);
        assertEquals("(1,1), (3,0)\r\n", newList.toString());
    }

}
