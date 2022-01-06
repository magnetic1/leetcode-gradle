/*
 * Leetcode - simplify_path
 */
package com.leetcode.simplify_path;

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

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> paths = new LinkedList<>();

        for (String str : strs) {
            if (str.equals("..")) {
                if (paths.size() > 0) {
                    paths.pop();
                }
            } else if (str.length() > 0 && !str.equals(".")){
                paths.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!paths.isEmpty()) {
            String t = paths.pollLast();
            sb.append('/');
            sb.append(t);
        }

        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }

}
