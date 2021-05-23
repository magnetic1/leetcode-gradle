/*
 * Leetcode - maximum_xor_with_an_element_from_array
 */
package com.leetcode.maximum_xor_with_an_element_from_array;
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

    static final int INF = 1 << 30;

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        // sort & de-dup
        Arrays.sort(nums);
        int len = 0;
        for (int i = 0, prev = -1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[len++] = nums[i];
            }
        }
        // for loop
        final int querySize = queries.length;
        int[] ans = new int[querySize];
        for (int i = 0; i < querySize; i++) {
            int threshold = queries[i][1];
            int r = binarySearch(nums, 0, len, threshold) - 1;
            if (r < 0) {
                ans[i] = -1;
                continue;
            }
            int mod = INF;
            while (mod > 1 && 0 == (mod & threshold)) mod >>>= 1;
            ans[i] = query(nums, 0, r, mod, queries[i][0]);
        }
        return ans;
    }

    private static int query(int[] nums, int l, int r, int threshold, int x) {
        for (; threshold != 0 && l < r; threshold >>>= 1) {
            if ((threshold & nums[l]) == (threshold & nums[r])) {
                continue;
            }
            int mid = binarySearch(nums, l, r + 1, nums[l] | (threshold - 1));
            if (0 == (x & threshold)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] ^ x;
    }

    private static int binarySearch(int[] arr, int l, int r, int target) {
        return Math.abs(Arrays.binarySearch(arr, l, r, target) + 1);
    }
}
