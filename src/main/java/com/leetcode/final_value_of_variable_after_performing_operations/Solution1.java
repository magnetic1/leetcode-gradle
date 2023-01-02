/*
 * Leetcode - final_value_of_variable_after_performing_operations
 */
package com.leetcode.final_value_of_variable_after_performing_operations;
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

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String op : operations) {
            if ("++X".equals(op) || "X++".equals(op)) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

}
