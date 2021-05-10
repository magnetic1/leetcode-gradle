/*
 * Leetcode - leaf_similar_trees
 */
package com.leetcode.leaf_similar_trees;
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeafValues(root1);
        List<Integer> list2 = getLeafValues(root2);

        return list1.equals(list2);
    }

    List<Integer> getLeafValues(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        dfs(node, res);
        return res;
    }

    void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }

}
