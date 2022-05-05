/*
 * Leetcode - subarray_product_less_than_k
 */
package com.leetcode.subarray_product_less_than_k;

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

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 1;
        int v = nums[0];
        int res = 0;
        while (right <= nums.length) {
            if (v < k) {
                if (right == nums.length) {
                    return res + right - left;
                }
                res += right - left;
                v *= nums[right];
                right++;
            } else if (left < (right - 1)) {
                v /= nums[left];
                left++;
            } else {
                left++;
                right++;
                if (left < nums.length) {
                    v = nums[left];
                }
            }
        }
        return res;
    }

}
