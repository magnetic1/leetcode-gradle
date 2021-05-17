/*
 * Leetcode - cousins_in_binary_tree
 */
package com.leetcode.cousins_in_binary_tree;
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode[]> queue = new ArrayDeque<>();

        queue.add(new TreeNode[]{root, root.left});
        queue.add(new TreeNode[]{root, root.right});

        TreeNode xParent = null, yParent = null;
        boolean findX = false, findY = false;

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode[] value = queue.poll();
                TreeNode node = value != null ? value[1] : null;
                if (node != null) {
                    if (node.val == x) {
                        findX = true;
                        xParent = value[0];
                    } else if (node.val == y) {
                        findY = true;
                        yParent = value[0];
                    }
                    if (node.left != null) {
                        queue.add(new TreeNode[]{value[1], node.left});
                    }
                    if (node.right != null) {
                        queue.add(new TreeNode[]{value[1], node.right});
                    }
                }
            }

            if (findX && findY) {
                return xParent != yParent;
            }

            if (findX || findY) {
                return false;
            }
        }
        return false;
    }


}
