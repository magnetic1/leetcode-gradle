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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int prod = 1, res = 0;
        while (right < nums.length) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

}
