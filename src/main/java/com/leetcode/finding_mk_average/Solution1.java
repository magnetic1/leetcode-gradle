/*
 * Leetcode - finding_mk_average
 */
package com.leetcode.finding_mk_average;

import java.util.*;
import java.util.function.BiFunction;

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


    static class MKAverage {
        private int m, k, size1 = 0, size3 = 0;

        private Queue<Integer> q;
        private TreeMap<Integer, Integer> s1;
        private TreeMap<Integer, Integer> s2;
        private TreeMap<Integer, Integer> s3;
        private long sum2 = 0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            this.q = new ArrayDeque<>();
            this.s1 = new TreeMap<>();
            this.s2 = new TreeMap<>();
            this.s3 = new TreeMap<>();

        }

        public void addElement(int num) {
            q.add(num);
            if (q.size() <= m) {
                addOne(s2, num);
                sum2 += num;

                if (q.size() == m) {
                    while (size1 < k) {
                        int firstKey = s2.firstKey();
                        addOne(s1, firstKey);
                        removeOne(s2, firstKey);
                        sum2 -= firstKey;
                        size1++;
                    }
                    while (size3 < k) {
                        int lastKey = s2.lastKey();
                        addOne(s3, lastKey);
                        removeOne(s2, lastKey);
                        sum2 -= lastKey;
                        size3++;
                    }
                }
                return;
            }

            if (num < s1.lastKey()) {
                addOne(s1, num);
                int lastKey = s1.lastKey();
                removeOne(s1, lastKey);
                addOne(s2, lastKey);
                sum2 += lastKey;
            } else if (num > s3.firstKey()) {
                addOne(s3, num);
                int firstKey = s3.firstKey();
                removeOne(s3, firstKey);
                addOne(s2, firstKey);
                sum2 += firstKey;
            } else {
                addOne(s2, num);
                sum2 += num;
            }

            int x = q.poll();
            if (s1.containsKey(x)) {
                removeOne(s1, x);
                int firstKey = s2.firstKey();
                removeOne(s2, firstKey);
                addOne(s1, firstKey);
                sum2 -= firstKey;
            } else if (s3.containsKey(x)) {
                removeOne(s3, x);
                int lastKey = s2.lastKey();
                removeOne(s2, lastKey);
                addOne(s3, lastKey);
                sum2 -= lastKey;
            } else {
                removeOne(s2, x);
                sum2 -= x;
            }
        }

        private void removeOne(TreeMap<Integer, Integer> treeMap, int num) {
            treeMap.put(num, treeMap.get(num) - 1);
            if (treeMap.get(num) == 0) {
                treeMap.remove(num);
            }
        }

        private void addOne(TreeMap<Integer, Integer> treeMap, int num) {
            treeMap.compute(num, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }

        public int calculateMKAverage() {
            if (q.size() < m) {
                return -1;
            }
            return (int) (sum2 / (m - 2 * k));
        }
    }


}
