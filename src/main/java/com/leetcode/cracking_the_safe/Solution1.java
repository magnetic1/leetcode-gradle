/*
 * Leetcode - cracking_the_safe
 */
package com.leetcode.cracking_the_safe;
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

    Set<Integer> seen = new HashSet<Integer>();
    StringBuffer ans = new StringBuffer();
    int mod;
    int k;

    public String crackSafe(int n, int k) {
        mod = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    void dfs(int s) {
        for (int i = 0; i < k; i++) {
            int v = s * 10 + i;
            if (!seen.contains(v)) {
                seen.add(v);
                dfs(v % mod);
                ans.append(i);
            }
        }
    }

}
