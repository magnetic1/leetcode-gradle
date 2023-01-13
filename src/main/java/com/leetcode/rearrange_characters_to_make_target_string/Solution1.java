/*
 * Leetcode - rearrange_characters_to_make_target_string
 */
package com.leetcode.rearrange_characters_to_make_target_string;

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

    public int rearrangeCharacters(String s, String target) {
        int n = s.length(), m = target.length();
        int l = 0, r = l + m - 1;
        int res = Integer.MAX_VALUE;

        int[] t = new int[26];
        for (int i = 0; i < m; i++) {
            t[target.charAt(i) - 'a']++;
        }

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (t[i] == 0) {
                continue;
            }
            res = Math.min(res, arr[i] / t[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.rearrangeCharacters("ilovecodingonleetcode", "code");
    }
}
