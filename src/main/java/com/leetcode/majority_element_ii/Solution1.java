/*
 * Leetcode - majority_element_ii
 */
package com.leetcode.majority_element_ii;
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

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int[] elements = new int[2];
        int[] votes = new int[2];

        for (int num : nums) {
            if (votes[0] > 0 && num == elements[0]) {
                votes[0]++;
            } else if (votes[1] > 0 && num == elements[1]) {
                votes[1]++;
            } else if (votes[0] == 0) {
                votes[0]++;
                elements[0] = num;
            } else if (votes[1] == 0) {
                votes[1]++;
                elements[1] = num;
            } else {
                votes[0]--;
                votes[1]--;
            }
        }

        int[] cnt = new int[2];
        for (int num : nums) {
            if (elements[0] == num) {
                cnt[0]++;
            } else if (elements[1] == num) {
                cnt[1]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (votes[0] > 0 && cnt[0] > (n / 3)) {
            res.add(elements[0]);
        }
        if (votes[1] > 0 && cnt[1] > (n / 3)) {
            res.add(elements[1]);
        }

        return res;
    }

}
