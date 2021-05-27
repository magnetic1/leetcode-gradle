/*
 * Leetcode - hamming_distance
 */
package com.leetcode.hamming_distance;
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
class Solution2 implements Solution {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
