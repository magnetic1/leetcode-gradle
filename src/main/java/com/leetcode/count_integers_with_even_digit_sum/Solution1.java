/*
 * Leetcode - count_integers_with_even_digit_sum
 */
package com.leetcode.count_integers_with_even_digit_sum;

import java.util.*;

import org.wzq.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            int x = i, sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0) {
                res += 1;
            }
        }
        return res;
    }

}
