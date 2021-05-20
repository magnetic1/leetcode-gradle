/*
 * Leetcode - find_kth_largest_xor_coordinate_value
 */
package com.leetcode.find_kth_largest_xor_coordinate_value;
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

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<>();

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(dp[i][j]);
            }
        }

        results.sort((num1, num2) -> num2 - num1);

        return results.get(k - 1);
    }

}
