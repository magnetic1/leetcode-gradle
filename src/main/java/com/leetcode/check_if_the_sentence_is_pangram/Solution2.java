/*
 * Leetcode - check_if_the_sentence_is_pangram
 */
package com.leetcode.check_if_the_sentence_is_pangram;

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
class Solution2 implements Solution {

    public boolean checkIfPangram(String sentence) {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            state |= 1 << (c - 'a');
        }

        return state == (1 << 26) - 1;
    }

}
