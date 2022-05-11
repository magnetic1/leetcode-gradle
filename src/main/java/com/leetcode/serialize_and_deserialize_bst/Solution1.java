/*
 * Leetcode - serialize_and_deserialize_bst
 */
package com.leetcode.serialize_and_deserialize_bst;

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

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postOrder(root, list);
            String s = list.toString();
            return s.substring(1, s.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] strs = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<>();
            for (String str : strs) {
                stack.push(Integer.parseInt(str));
            }

            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private TreeNode construct(int minValue, int maxValue, Deque<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < minValue || stack.peek() > maxValue) {
                return null;
            }

            Integer value = stack.pop();
            TreeNode node = new TreeNode(value);
            node.right = construct(value, maxValue, stack);
            node.left = construct(minValue, value, stack);
            return node;
        }

        private void postOrder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }

            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.val);
        }
    }

}
