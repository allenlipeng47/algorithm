package com.pli.project.algorithm;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import com.pli.project.algorithm.util.TreeNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.IconInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by lipeng on 2015/12/12.
 */
public class test {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public static void main(String[] args) {
        System.setOut(new PrintStream(outContent));
        System.out.println("aaa");
        if (outContent.toString().equals("aaa")) {

        }
        System.out.println(outContent.toString());

    }




}