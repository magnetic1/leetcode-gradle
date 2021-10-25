/*
 * Leetcode - search_a_2d_matrix_ii
 */
package com.leetcode.search_a_2d_matrix_ii;

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

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0, toIndex = n; i < m && toIndex >= 0; i++) {
            int index = Arrays.binarySearch(matrix[i], 0, toIndex, target);
            if (index >= 0) {
                return true;
            } else {
                toIndex = -1 - index;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.searchMatrix(
            new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}
            },
            5
        );
    }
}
