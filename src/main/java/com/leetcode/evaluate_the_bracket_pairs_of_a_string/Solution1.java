/*
 * Leetcode - evaluate_the_bracket_pairs_of_a_string
 */
package com.leetcode.evaluate_the_bracket_pairs_of_a_string;
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

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> entry : knowledge) {
            map.put(entry.get(0), entry.get(1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int start = ++i;
                while (s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);
                sb.append(map.getOrDefault(key, "?"));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
