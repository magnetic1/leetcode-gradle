/*
 * Leetcode - minimum_elements_to_add_to_form_a_given_sum
 */
package com.leetcode.minimum_elements_to_add_to_form_a_given_sum;
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

    public int minElements(int[] nums, int limit, int goal) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        long diff = sum - goal;

        return (int) ((Math.abs(diff) - 1) / limit + 1);
    }

}
