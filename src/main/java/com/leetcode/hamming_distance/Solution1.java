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
class Solution1 implements Solution {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            if ((x % 2) != (y % 2)) {
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }

        return ans;
    }

}
