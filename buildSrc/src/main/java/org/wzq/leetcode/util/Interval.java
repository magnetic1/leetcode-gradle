package org.wzq.leetcode.util;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }
}
