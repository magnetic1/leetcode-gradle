/*
 * Leetcode - check_if_number_has_equal_digit_count_and_digit_value
 */
package com.leetcode.check_if_number_has_equal_digit_count_and_digit_value;
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

    public boolean digitCount(String num) {
        int n = num.length();
        char[] arr = new char[n];
        Arrays.fill(arr, '0');
        for (int i = 0; i < n; i++) {
            int c = num.charAt(i);
            if (c >= '0' && c < n + '0') {
                arr[c - '0']++;
            }
        }
        return num.equals(new String(arr));
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.digitCount("1210");
    }

}
