/*
 * Leetcode - number_of_ways_to_stay_in_the_same_place_after_some_steps
 */
package com.leetcode.number_of_ways_to_stay_in_the_same_place_after_some_steps;
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
    int mod = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;

        int cache = 0, tmp = 0;
        for (int i = 1; i <= steps; i++) {
            cache = dp[0];
            dp[0] = (dp[0] + dp[1]) % mod;
            for (int j = 1; j < maxColumn; j++) {
                tmp = dp[j];
                dp[j] = ((cache + dp[j]) % mod + dp[j + 1]) % mod;
                cache = tmp;
            }
            dp[maxColumn] = (cache + dp[maxColumn]) % mod;
        }

        return dp[0];
    }

}
