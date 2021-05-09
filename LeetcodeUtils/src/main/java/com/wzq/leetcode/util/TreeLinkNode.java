package com.wzq.leetcode.util;

import java.util.List;
import java.util.ArrayList;

public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    /**
     * Constructor
     * @param x value of this node.
     */
    public TreeLinkNode(int x) {
        val = x;
    }

    /**
     * Serialization (in BFS order)
     */
    public String toString() {
        return bfs().toString();
    }

    /** parse the tree in BFS order */
    private List<List<Integer>> bfs() {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeLinkNode> buffer = new ArrayList<>();
        buffer.add(this);
        while (!buffer.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = buffer.remove(0);
                if (node != null) {
                    thisLevel.add(node.val);
                    buffer.add(node.left);
                    buffer.add(node.right);
                } else {
                    thisLevel.add(null);
                }
            }
            if (thisLevel.isEmpty()) continue;
            for (Integer n : thisLevel) {
                if (n != null) {
                    res.add(thisLevel);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(1);
        System.out.println(node);
    }
}

