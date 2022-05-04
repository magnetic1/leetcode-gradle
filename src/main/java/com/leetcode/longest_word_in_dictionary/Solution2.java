/*
 * Leetcode - longest_word_in_dictionary
 */
package com.leetcode.longest_word_in_dictionary;

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

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String ans = "";

        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (ans.length() < word.length() || (ans.length() == word.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestWord(new String[]{"k", "lg", "it", "oidd", "oid", "oiddm", "kfk", "y", "mw", "kf", "l", "o", "mwaqz", "oi", "ych", "m", "mwa"}));
    }

}
