package com.wzq.leetcode.util;

public class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int x) {
        this.label = x;
    }

    public String toString() {
        RandomListNode cur = this;

        String str;
        for (str = ""; cur != null; cur = cur.next) {
            str = str + cur.label;
            if (cur.next != null) {
                str = str + "[" + cur.random.label + "]";
                str = str + "->";
            } else {
                str = str + "[null]";
            }
        }

        return str;
    }
}
