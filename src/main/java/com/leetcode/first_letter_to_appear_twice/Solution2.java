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
class Solution2 implements Solution {

    public char repeatedCharacter(String s) {
        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int x = 1 << (letter - 'a');
            if ((state & x) != 0) {
                return letter;
            }
            state |= x;
        }
        return '*';
    }

}
