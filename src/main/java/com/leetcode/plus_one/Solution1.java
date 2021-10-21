/*
 * Leetcode - plus_one
 */
package com.leetcode.plus_one;
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

    public int[] plusOne(int[] digits) {
        int v = 1;
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = digits[i] + v;
            if (num >= 10) {
                digits[i] = 0;
                v = 1;
            } else {
                digits[i] = num;
                v = 0;
                break;
            }
        }

        if (v == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

        return digits;
    }

}
