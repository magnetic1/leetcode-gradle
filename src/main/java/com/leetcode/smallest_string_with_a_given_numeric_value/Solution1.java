/*
 * Leetcode - smallest_string_with_a_given_numeric_value
 */
package com.leetcode.smallest_string_with_a_given_numeric_value;
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

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (26 * (n - 1) >= k - 1) {
                sb.append('a');
                k--;
            } else {
                sb.append((char) ('a' + k - 26 * (n - 1) - 1));
                k = 26 * (n - 1);
            }
            n--;
        }
        return sb.toString();
    }

}
