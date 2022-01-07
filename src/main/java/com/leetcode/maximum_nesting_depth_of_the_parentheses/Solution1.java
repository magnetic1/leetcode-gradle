/*
 * Leetcode - maximum_nesting_depth_of_the_parentheses
 */
package com.leetcode.maximum_nesting_depth_of_the_parentheses;

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

    public int maxDepth(String s) {
        int res = 0, num = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num++;
                res = Math.max(res, num);
            } else if (c == ')') {
                num--;
            }
        }

        return res;
    }

}
