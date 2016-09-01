package com.pli.project.algorithm;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import com.pli.project.algorithm.util.TreeNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.IconInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lipeng on 2015/12/12.
 */
public class test {

    public void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }




}