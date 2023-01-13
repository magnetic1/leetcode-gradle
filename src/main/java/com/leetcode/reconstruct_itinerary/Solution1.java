/*
 * Leetcode - reconstruct_itinerary
 */
package com.leetcode.reconstruct_itinerary;

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
    Map<String, PriorityQueue<String>> map;

    List<String> res = new ArrayList<>();

    int count = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>(Comparator.reverseOrder()));
            }
            map.get(from).add(to);
            count++;
        }

        dfs("JFK");
        res.add("JFK");

        Collections.reverse(res);
        return res;
    }

    private void dfs(String from) {
        if (!map.containsKey(from)) {
            return;
        }

        while (!map.get(from).isEmpty()) {
            String to = map.get(from).poll();
            dfs(to);
            res.add(to);
        }

    }

}
