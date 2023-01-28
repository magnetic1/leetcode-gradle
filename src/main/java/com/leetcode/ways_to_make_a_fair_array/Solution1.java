/*
 * Leetcode - ways_to_make_a_fair_array
 */
package com.leetcode.ways_to_make_a_fair_array;

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

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        arr[n - 1][0] = 0;
        arr[n - 1][1] = 0;
        // arr[n - 2][(n - 2) % 2] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int t = i % 2;
            arr[i][t] = arr[i + 1][t] + nums[i + 1];
            arr[i][t ^ 1] = arr[i + 1][t ^ 1];
        }

        int res = 0, sum0 = 0, sum1 = 0;
        for (int i = 0; i < n; i++) {
            if (sum0 + arr[i][0] == sum1 + arr[i][1]) {
                res++;
            }
            if (i % 2 == 0) {
                sum0 += nums[i];
            } else {
                sum1 += nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.waysToMakeFair(new int[]{1, 1, 1});
    }
}
