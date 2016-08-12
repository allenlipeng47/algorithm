package com.pli.project.algorithm.amz;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        Arrays.fill(product, 1);
        int leftProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            product[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            product[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return product;
    }
}
