/*
 * Leetcode - check_if_matrix_is_x_matrix
 */
package com.leetcode.check_if_matrix_is_x_matrix;
import java.util.*;
import org.wzq.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (i == j || n - 1 == i + j) {
                    if (num == 0) {
                        return false;
                    }
                } else if (num != 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
