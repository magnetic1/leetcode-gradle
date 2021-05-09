package org.wzq.leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        List<Node> list = new ArrayList<>();
        list.add(this);
        while (!list.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node node = list.remove(0);
                nums.add((node == null) ? null : node.val);
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }
            if (nums.isEmpty()) continue;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) != null) {
                    sb.append(nums).append(", ");
                    break;
                }
            }
        }
        if (sb.length() > 2) sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }


}
