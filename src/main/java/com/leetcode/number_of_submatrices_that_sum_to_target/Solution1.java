/*
 * Leetcode - number_of_submatrices_that_sum_to_target
 */
package com.leetcode.number_of_submatrices_that_sum_to_target;
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

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int x1 = 0; x1 < m; x1++) {
            for (int y1 = 0; y1 < n; y1++) {
                for (int x2 = x1; x2 < m; x2++) {
                    for (int y2 = y1; y2 < n; y2++) {
                        int sum = dp[x2 + 1][y2 + 1] - dp[x1][y2 + 1] - dp[x2 + 1][y1] + dp[x1][y1];
                        if (sum == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

}
