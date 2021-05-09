package org.wzq.leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x) {
        val = x;
    }

    public String toString() {
        return bfs().toString();
    }

    private List<List<Integer>> bfs() {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> buffer = new ArrayList<>();
        buffer.add(this);
        while (!buffer.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = buffer.remove(0);
                if (node == null) {
                    line.add(null);
                } else {
                    line.add(node.val);
                    buffer.add(node.left);
                    buffer.add(node.right);
                }
            }
            if (line.isEmpty()) continue;
            for (Integer n : line) {
                if (n != null) res.add(line);
                break;
            }
        }
        return res;
    }

}
