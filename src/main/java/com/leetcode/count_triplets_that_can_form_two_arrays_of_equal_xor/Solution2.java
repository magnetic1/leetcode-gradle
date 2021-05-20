/*
 * Leetcode - count_triplets_that_can_form_two_arrays_of_equal_xor
 */
package com.leetcode.count_triplets_that_can_form_two_arrays_of_equal_xor;
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
class Solution2 implements Solution {

    /**
     * 二重循环
     *
     * @param arr 数组
     * @return num
     */
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (xors[k + 1] == xors[i]) {
                    ans += k - i;
                }
            }
        }

        return ans;
    }

}
