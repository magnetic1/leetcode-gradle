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
class Solution1 implements Solution {

    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (b, a) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));

        int[] dp = new int[n];
        dp[0] = cuboids[0][2];

        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int pre = 0; pre < i; pre++) {
                if (cuboids[pre][0] >= cuboids[i][0] && cuboids[pre][1] >= cuboids[i][1] &&
                        cuboids[pre][2] >= cuboids[i][2]) {
                    dp[i] = Math.max(dp[pre] + cuboids[i][2], dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxHeight(new int[][]{
                        {36, 46, 41}, {15, 100, 100}, {75, 91, 59}, {13, 82, 64}
                }
        ));
    }

}
