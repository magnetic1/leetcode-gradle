/*
 * Leetcode - largest_merge_of_two_strings
 */
package com.leetcode.largest_merge_of_two_strings;

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

    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }

}
