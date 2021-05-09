package org.wzq.leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    public Integer num = null;
    public List<NestedInteger> nums = null;

    public NestedInteger() {
        this.nums = new ArrayList<>();
    }

    public NestedInteger(int num) {
        this.num = num;
    }

    public boolean isInteger() {
        return this.nums == null;
    }

    public Integer getInteger() {
        return this.num;
    }

    public List<NestedInteger> getList() {
        return this.nums;
    }

    public boolean add(NestedInteger n) {
        if (this.isInteger()) {
            return false;
        } else {
            this.nums.add(n);
            return true;
        }
    }

    public String toString() {
        if (this.isInteger()) {
            return "" + this.num;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            for (NestedInteger ni : this.nums) {
                sb.append(ni.toString());
                sb.append(",");
            }

            int len = sb.length();
            sb.delete(len - 1, len);
            sb.append("]");
            return sb.toString();
        }
    }
}
