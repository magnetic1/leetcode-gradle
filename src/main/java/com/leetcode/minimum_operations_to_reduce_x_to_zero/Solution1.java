/*
 * Leetcode - minimum_operations_to_reduce_x_to_zero
 */
package com.leetcode.minimum_operations_to_reduce_x_to_zero;
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

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i + 1];
        }

        int ans = n + 1, right = n;
        for (int left = 0; left <= n; left++) {
            while (right >= 0 && prefix[left] + suffix[n-right] > x) {
                right--;
            }
            if (right >= 0 && prefix[left] + suffix[n-right] == x) {
                ans = Math.min(left + right, ans);
            }

        }
        return ans > n ? -1 : ans;
    }

}
