/*
 * Leetcode - count_pairs_with_xor_in_a_range
 */
package com.leetcode.count_pairs_with_xor_in_a_range;

import java.util.*;

import org.wzq.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {
    private Trie root = null;
    // 最高位的二进制位编号为 14
    private static final int HIGH_BIT = 14;

    public int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    public int f(int[] nums, int high) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], high);
        }
        return res;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    public int get(int num, int high) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;

            if (((high >> k) & 1) == 1) {
                if (cur.son[r] != null) {
                    sum += cur.son[r].sum;
                }
                cur = cur.son[r ^ 1];
            } else {
                cur = cur.son[r];
            }

            if (cur == null) {
                return sum;
            }
        }
        sum += cur.sum;
        return sum;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.countPairs(new int[]{1, 4, 2, 7}, 2, 6);
    }

}

class Trie {
    // son[0] 表示左子树，son[1] 表示右子树
    Trie[] son = new Trie[2];
    int sum;

    public Trie() {
        sum = 0;
    }
}


