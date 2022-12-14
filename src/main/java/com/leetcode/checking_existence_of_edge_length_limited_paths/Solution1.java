/*
 * Leetcode - checking_existence_of_edge_length_limited_paths
 */
package com.leetcode.checking_existence_of_edge_length_limited_paths;

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

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        Integer[] indexes = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> queries[a][2] - queries[b][2]);

        UnionFind uf = new UnionFind(n);
        boolean[] ans = new boolean[queries.length];
        int k = 0;
        for (int index : indexes) {
            while (k < edgeList.length && edgeList[k][2] < queries[index][2]) {
                uf.merge(edgeList[k][0], edgeList[k][1]);
                k++;
            }
            ans[index] = (uf.find(queries[index][0]) == uf.find(queries[index][1]));
        }

        return ans;
    }

}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void merge(int x, int y) {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }
}
