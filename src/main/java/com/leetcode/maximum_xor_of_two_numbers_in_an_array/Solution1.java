/*
 * Leetcode - maximum_xor_of_two_numbers_in_an_array
 */
package com.leetcode.maximum_xor_of_two_numbers_in_an_array;
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

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }

            int xNext = 2 * x + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }

}
