/**
 * Leetcode - employee_importance
 */
package com.leetcode.employee_importance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(map, map.get(id));
    }

    int dfs(Map<Integer, Employee> map, Employee e) {
        int ans = e.importance;
        for (int i : e.subordinates) {
            Employee e1 = map.get(i);
            ans += dfs(map, e1);
        }

        return ans;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
