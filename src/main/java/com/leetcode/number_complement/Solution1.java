/*
 * Leetcode - number_complement
 */
package com.leetcode.number_complement;

import java.util.*;

import org.wzq.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int findComplement(int num) {
        int res = 0, len = 0;

        while (num != 0) {
            res += (1 - num % 2) << len;

            len++;
            num = num >> 1;
        }
        return res;
    }

}
