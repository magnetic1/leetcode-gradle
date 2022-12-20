/*
 * Leetcode - reach_a_number
 */
package com.leetcode.reach_a_number;

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

    public int reachNumber(int target) {
        int distance = Math.abs(target);
        int i = 0;
        while (distance > 0) {
            i++;
            distance -= i;
        }
        if (distance % 2 != 0) {
            i = i + 1 + i % 2;
        }
        return i;
    }

}
