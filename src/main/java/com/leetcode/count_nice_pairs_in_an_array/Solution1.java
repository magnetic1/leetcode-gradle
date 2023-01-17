/*
 * Leetcode - count_nice_pairs_in_an_array
 */
package com.leetcode.count_nice_pairs_in_an_array;

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

    public int countNicePairs(int[] nums) {
        int mod = (int) (1e9 + 7);
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int t = num, rev = 0;
            while (t > 0) {
                rev = rev * 10 + t % 10;
                t /= 10;
            }

            ans = (ans + map.getOrDefault(num - rev, 0)) % mod;
            map.put(num - rev, map.getOrDefault(num - rev, 0) + 1);
        }
        return ans;
    }

}
