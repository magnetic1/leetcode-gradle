/*
 * Leetcode - sum_of_digits_of_string_after_convert
 */
package com.leetcode.sum_of_digits_of_string_after_convert;
import java.util.*;
import org.wzq.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }

        String number = sb.toString();
        int value = 0;
        for (int i = 0; i < k; i++) {
            value = 0;
            for (int j = 0; j < number.length(); j++) {
                value += number.charAt(j) - '0';
            }
            number = String.valueOf(value);
        }

        return value;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.getLucky("leetcode", 2));
    }

}
