/*
 * Leetcode - design_add_and_search_words_data_structure
 */
package com.leetcode.design_add_and_search_words_data_structure;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

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

    static class WordDictionary {
        WordNode rootNode;

        public WordDictionary() {
            rootNode = new WordNode();
        }

        public void addWord(String word) {
            int n = word.length();
            WordNode node = rootNode;

            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (node.next.containsKey(c)) {
                    node = node.next.get(c);
                } else {
                    WordNode newNode = new WordNode();
                    node.next.put(c, newNode);
                    node = newNode;
                }
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            List<WordNode> nodeList = new ArrayList<>();
            List<WordNode> nextNodeList = new ArrayList<>();
            nodeList.add(rootNode);
            int n = word.length();

            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);

                for (WordNode pre : nodeList) {
                    if (c == '.') {
                        nextNodeList.addAll(pre.next.values());
                    } else if (pre.next.containsKey(c)) {
                        nextNodeList.add(pre.next.get(c));
                    }
                }

                nodeList = nextNodeList;
                nextNodeList = new ArrayList<>();
            }

            return nodeList.stream().anyMatch(wordNode -> wordNode.isWord);
        }

    }

    static class WordNode {
        boolean isWord;
        Map<Character, WordNode> next;

        WordNode() {
            next = new HashMap<>();
        }
    }

}
