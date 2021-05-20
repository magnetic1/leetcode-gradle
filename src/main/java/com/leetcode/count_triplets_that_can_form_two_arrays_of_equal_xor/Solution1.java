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
class Solution1 implements Solution {
    /**
     * 三重循环
     *
     * @param arr 数组
     * @return num
     */
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        xors[0] = 0;
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = xors[j] ^ xors[i];
                    int b = xors[k + 1] ^ xors[j];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

}
