/*
 * Leetcode - count_asterisks
 */
package com.leetcode.count_asterisks;
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

    public int countAsterisks(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                res += 1;
            } else if (c == '|') {
                i = next(s, i + 1);
            }
        }
        return res;
    }

    int next(String s, int i) {
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                return i;
            }
        }
        return i;
    }

}
