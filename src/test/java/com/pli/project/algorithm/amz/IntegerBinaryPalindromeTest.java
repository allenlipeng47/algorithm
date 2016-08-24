package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/23.
 */
public class IntegerBinaryPalindromeTest {

    @Test
    public void test1() {
        IntegerBinaryPalindrome i = new IntegerBinaryPalindrome();
        assert i.isPalindrome(6) == true;
        assert i.isPalindrome(7) == true;
        assert i.isPalindrome(408) == true;
        assert i.isPalindrome(409) == false;

    }

}
