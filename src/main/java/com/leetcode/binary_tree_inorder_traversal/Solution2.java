/*
 * Leetcode - binary_tree_inorder_traversal
 */
package com.leetcode.binary_tree_inorder_traversal;

import org.wzq.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

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

    public List<Integer> inorderTraversal(TreeNode head) {
        List<Integer> res = new ArrayList<>();

        Stack<Function<Void, Void>> stack = new Stack<>();

        stack.push(leftFunction(res, stack, head));

        while (!stack.isEmpty()) {
            Function<Void, Void> f = stack.pop();
            f.apply(null);
        }

        return res;
    }

    private Function<Void, Void> leftFunction(List<Integer> res, Stack<Function<Void, Void>> stack, TreeNode node) {
        return unused -> {
            if (node == null) {
                return null;
            }
            stack.push(rightFunction(res, stack, node));
            stack.push(leftFunction(res, stack, node.left));
            return null;
        };
    }

    private Function<Void, Void> rightFunction(List<Integer> res, Stack<Function<Void, Void>> stack, TreeNode node) {
        return unused -> {
            if (node == null) {
                return null;
            }
            res.add(node.val);
            stack.push(leftFunction(res, stack, node.right));
            return null;
        };
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);

        Solution2 solution = new Solution2();
        List<Integer> res = solution.inorderTraversal(head);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
