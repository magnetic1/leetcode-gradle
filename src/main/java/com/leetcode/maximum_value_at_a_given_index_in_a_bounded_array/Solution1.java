/*
 * Leetcode - maximum_value_at_a_given_index_in_a_bounded_array
 */
package com.leetcode.maximum_value_at_a_given_index_in_a_bounded_array;

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

    @SuppressWarnings("UnnecessaryLocalVariable")
    public int maxValue(int n, int index, int maxSum) {
        int lCount = index, rCount = n - 1 - index; // 山峰左右两侧的元素数量
        int l = 1, r = maxSum; // 二分查找的左右边界

        while (l <= r) {
            int m = (l + r) / 2;
            long sum = m + helper(m, lCount) + helper(m, rCount);
            if (sum > maxSum) r = --m;
            else l = ++m;
        }
        return l - 1; // 此时，l 代表数组和恰好大于 maxSum 时的数组和。
    }

    private long helper(long max, long count) {
        if (max - 1 > count) {
            return (max - 1 + max - count) * count / 2;
        } else {
            return max * (max - 1) / 2 + count - (max - 1);
        }
    }

}
