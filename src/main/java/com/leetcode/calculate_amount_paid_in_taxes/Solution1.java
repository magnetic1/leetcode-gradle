/*
 * Leetcode - calculate_amount_paid_in_taxes
 */
package com.leetcode.calculate_amount_paid_in_taxes;
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

    public double calculateTax(int[][] brackets, int income) {
        int preUpper = 0, i = 0;
        double ans = 0;
        while (i < brackets.length && income > preUpper) {
            int upper = brackets[i][0], percent = brackets[i][1];
            ans += (double) percent / 100D * (Math.min(income, upper) - preUpper);
            preUpper = upper;
            i++;
        }
        return ans;
    }

}
