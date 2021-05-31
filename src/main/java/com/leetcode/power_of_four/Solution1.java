/*
 * Leetcode - power_of_four
 */
package com.leetcode.power_of_four;
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

    public boolean isPowerOfFour(int n) {
        for (int i = 0; i <= 32; i = i + 2) {
            int x = n >>> i;

            if (x == 1) {
                return true;
            } else if (x % 4 != 0) {
                return false;
            }
        }

        return false;
    }

}
