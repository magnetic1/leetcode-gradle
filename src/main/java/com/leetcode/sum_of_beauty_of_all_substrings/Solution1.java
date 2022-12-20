/*
 * Leetcode - sum_of_beauty_of_all_substrings
 */
package com.leetcode.sum_of_beauty_of_all_substrings;

import java.util.*;

import org.wzq.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4value will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int[] counts = new int[26];
            for (int value = i; value < s.length(); value++) {
                counts[s.charAt(value) - 'a']++;
                ans += max(counts) - min(counts);
            }
        }
        return ans;
    }

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(value, max);
        }
        return max;
    }

    private int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value > 0) {
                min = Math.min(value, min);
            }
        }
        return min;
    }

}
