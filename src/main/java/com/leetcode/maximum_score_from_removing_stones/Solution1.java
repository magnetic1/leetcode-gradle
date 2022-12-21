/*
 * Leetcode - maximum_score_from_removing_stones
 */
package com.leetcode.maximum_score_from_removing_stones;
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

    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));

        if (max > sum - max) {
            return sum - max;
        }
        return sum / 2;
    }

}
