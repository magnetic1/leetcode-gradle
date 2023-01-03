/*
 * Leetcode - check_if_numbers_are_ascending_in_a_sentence
 */
package com.leetcode.check_if_numbers_are_ascending_in_a_sentence;
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

    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");

        int pre = 0;
        for (String word : words) {
            if (word.length() > 0 && word.charAt(0) >= '0' && word.charAt(0) <= '9') {
                int value = Integer.parseInt(word);
                if (pre >= value) {
                    return false;
                }
                pre = value;
            }
        }
        return true;
    }

}
