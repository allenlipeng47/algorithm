package com.pli.project.algorithm.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/3/18.
 */
public class FindProduct {

    public List<Integer> findProduct(int n) {
        int product = 2;
        List<Integer> ans = new ArrayList<>();
        while (n > 1) {
            if (n % product == 0) {
                ans.add(product);
                n /= product;
            } else {
                product++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindProduct findProduct = new FindProduct();
        System.out.println(findProduct.findProduct(101));
    }
}
