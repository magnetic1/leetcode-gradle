/*
 * Leetcode - decode_xored_permutation
 */
package com.leetcode.decode_xored_permutation;
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

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }

        int x = 0;
        for (int i = 1; i < n; i += 2) {
            x ^= encoded[i];
        }

        int[] res = new int[n];
        res[0] = total ^ x;
        for (int i = 1; i < n; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }

        return res;
    }

}
