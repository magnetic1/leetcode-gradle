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
class Solution1 implements Solution {

    public String longestWord(String[] words) {
        WordTree wordTree = new WordTree('a');
        for (String word : words) {
            wordTree.add(word);
        }
        String ans = "";
        for (String word : words) {
            if (findWord(wordTree, word)) {
                if (ans.length() < word.length() || (ans.length() == word.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    boolean findWord(WordTree wordTree, String word) {
        int n = word.length();
        if (n == 0) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            String head = word.substring(0, i);
            if (!wordTree.find(head)) {
                return false;
            }
        }
        return true;
    }

    static class WordTree {
        boolean isWord = false;
        char c;
        WordTree[] nextWords = new WordTree[26];

        WordTree(char c) {
            this.c = c;
        }

        void add(String str) {
            if (str == null || str.length() == 0) {
                isWord = true;
                return;
            }

            char next = str.charAt(0);
            if (nextWords[next - 'a'] == null) {
                nextWords[next - 'a'] = new WordTree(next);
            }

            nextWords[next - 'a'].add(str.substring(1));
        }

        boolean find(String str) {
            if (str == null) {
                return false;
            }

            if (str.length() == 0) {
                return isWord;
            }

            char next = str.charAt(0);
            if (nextWords[next - 'a'] == null) {
                return false;
            }
            return nextWords[next - 'a'].find(str.substring(1));
        }
    }

    public static void main(String[] args) {
        WordTree wordTree = new WordTree('a');

        wordTree.add("hello");
        wordTree.add("hell");
        wordTree.add("o");
        System.out.println(wordTree.find("hello"));
        System.out.println(wordTree.find("hell"));
        System.out.println(wordTree.find("o"));

        Solution1 solution = new Solution1();
        System.out.println(solution.longestWord(new String[]{"k", "lg", "it", "oidd", "oid", "oiddm", "kfk", "y", "mw", "kf", "l", "o", "mwaqz", "oi", "ych", "m", "mwa"}));
    }
}
