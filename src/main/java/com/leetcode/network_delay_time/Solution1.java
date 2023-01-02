/*
 * Leetcode - network_delay_time
 */
package com.leetcode.network_delay_time;

import java.util.*;
import java.util.function.Function;

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

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            List<int[]> list = map.computeIfAbsent(time[0], key -> new ArrayList<>());
            list.add(time);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Set<Integer> nodeSet = new HashSet<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        pq.add(new int[]{k, 0});
        dist[k] = 0;

        while (!pq.isEmpty() && nodeSet.size() != n) {
            int[] node = pq.poll();
            int i = node[0];
            int d = node[1];

            nodeSet.add(i);
            if (dist[i] < d) {
                continue;
            }

            for (int[] time : map.getOrDefault(i, new ArrayList<>())) {
                int from = time[0], to = time[1], value = time[2];
                if (value + d < dist[to]) {
                    dist[to] = value + d;
                    pq.add(new int[]{to, dist[to]});
                }
            }


        }

        if (nodeSet.size() != n) {
            return -1;
        }
        return Arrays.stream(dist).max().getAsInt();
    }

}
