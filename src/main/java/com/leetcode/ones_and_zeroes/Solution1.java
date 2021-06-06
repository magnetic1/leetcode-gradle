/*
 * Leetcode - ones_and_zeroes
 */
package com.leetcode.ones_and_zeroes;
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

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] counts = new int[len][2];

        for (int i = 0; i < len; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                counts[i][str.charAt(j) - '0']++;
            }
        }

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int zeros = counts[i - 1][0], ones = counts[i - 1][1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }

        return dp[len][m][n];
    }

}
