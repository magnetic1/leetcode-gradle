/**
 * Leetcode - number_of_1_bits
 */
package com.leetcode.number_of_1_bits;

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

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

}
