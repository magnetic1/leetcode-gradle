/*
 * Leetcode - sentence_similarity_iii
 */
package com.leetcode.sentence_similarity_iii;
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

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        if (words1.length > words2.length) {
            String[] tmp = words1;
            words1 = words2;
            words2 = tmp;
        }

        int n = words1.length;
        int l = 0, r = 0;

        while (l < n && words1[l].equals(words2[l])) {
            l++;
        }

        while (r < n && words1[n - r - 1].equals(words2[words2.length - r - 1])) {
            r++;
        }

        return l + r >= n;

    }

}
