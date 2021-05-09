package com.wzq.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public String toString() {
        ListNode cursor = this;
        StringBuilder sb = new StringBuilder();

        do {
            sb.append(cursor.val).append("->");
            cursor = cursor.next;
        } while (cursor != null);

        int length = sb.length();
        if (length > 2) {
            sb.delete(length - 2, length);
        }

        return sb.toString();
    }
}
