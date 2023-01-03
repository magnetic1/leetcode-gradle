/*
 * Leetcode - first_letter_to_appear_twice
 */
package com.leetcode.first_letter_to_appear_twice;
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

    public char repeatedCharacter(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index = letter - 'a';
            if (arr[index] == 1) {
                return letter;
            }
            arr[index]++;
        }
        return '*';
    }

}
