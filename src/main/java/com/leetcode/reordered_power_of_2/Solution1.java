/*
 * Leetcode - reordered_power_of_2
 */
package com.leetcode.reordered_power_of_2;
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

    public boolean reorderedPowerOf2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        boolean[] visited = new boolean[chars.length];

        Arrays.sort(chars);

        return dfs(chars, visited, 0, 0);
    }

    boolean dfs(char[] chars, boolean[] visited, int len, int num) {
        int n = chars.length;
        if (len == n) {
            return (num & (num - 1)) == 0;
        }

        for (int i = 0; i < n; i++) {
            if ((num == 0 && chars[i] == '0') || visited[i] || (i > 0 && !visited[i - 1] && chars[i] == chars[i - 1])) {
                continue;
            }
            visited[i] = true;
            if (dfs(chars, visited, len + 1, num * 10 + chars[i] - '0')) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.reorderedPowerOf2(56635));
    }

}
