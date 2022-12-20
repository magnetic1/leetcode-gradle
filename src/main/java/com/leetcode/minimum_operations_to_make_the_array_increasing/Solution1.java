/*
 * Leetcode - minimum_operations_to_make_the_array_increasing
 */
package com.leetcode.minimum_operations_to_make_the_array_increasing;

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

    public int minOperations(int[] nums) {
        int count = 0, pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                pre = nums[i];
            } else {
                count += pre - nums[i] + 1;
                pre += 1;
            }
        }
        return count;
    }

}
