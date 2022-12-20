/*
 * Leetcode - maximum_height_by_stacking_cuboids
 */
package com.leetcode.maximum_height_by_stacking_cuboids;

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
class Solution2 implements Solution {

    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (o1, o2) -> o2[0] - o1[0]);

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = cuboids[i][2];
        }

        int max = Arrays.stream(dp[0]).max().getAsInt();

        for (int i = 0; i < n; i++) {
            int height = 0;
            for (int j = 0; j <= i; j++) {
                height = Math.max(height, dp[j][i + 1]);
            }

            for (int next = i + 1; next < n; next++) {
                if (cuboids[i][0] >= cuboids[next][0] && cuboids[i][1] >= cuboids[next][1] &&
                        cuboids[i][2] >= cuboids[next][2]) {
                    dp[i + 1][next + 1] = Math.max(height + cuboids[next][2], dp[i + 1][next + 1]);
                    max = Math.max(dp[i + 1][next + 1], max);
                }
            }
        }
        return max;
    }

}
