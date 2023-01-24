/*
 * Leetcode - queries_on_number_of_points_inside_a_circle
 */
package com.leetcode.queries_on_number_of_points_inside_a_circle;
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

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            for (int[] point : points) {
                int dx = x - point[0];
                int dy = y - point[1];
                if (dx * dx + dy * dy <= r * r) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

}
