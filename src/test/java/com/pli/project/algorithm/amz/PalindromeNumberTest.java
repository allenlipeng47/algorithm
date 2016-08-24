package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/23.
 */
public class PalindromeNumberTest {

    @Test
    public void test1() {
        PalindromeNumber p = new PalindromeNumber();
        assert p.isPalindrome(121) == true;
        assert p.isPalindrome(7461647) == true;
        assert p.isPalindrome(74616472) == false;
        assert p.isPalindrome(2147483647) == false;
    }

}
