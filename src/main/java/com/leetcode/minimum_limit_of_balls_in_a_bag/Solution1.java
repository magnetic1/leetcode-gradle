/*
 * Leetcode - minimum_limit_of_balls_in_a_bag
 */
package com.leetcode.minimum_limit_of_balls_in_a_bag;
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

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();

        while (left <= right) {
            int mid = (left + right) / 2;
            int ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }

            if (ops <= maxOperations) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
