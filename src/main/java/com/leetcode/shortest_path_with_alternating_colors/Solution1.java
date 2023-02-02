/*
 * Leetcode - shortest_path_with_alternating_colors
 */
package com.leetcode.shortest_path_with_alternating_colors;

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
    Map<Integer, List<Integer>> redMap;
    Map<Integer, List<Integer>> blueMap;
    int[][] dist;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        this.blueMap = new HashMap<Integer, List<Integer>>() {{
            for (int i = 0; i < n; i++) {
                put(i, new ArrayList<>());
            }
            for (int[] edge : blueEdges) {
                get(edge[0]).add(edge[1]);
            }
        }};
        this.redMap = new HashMap<Integer, List<Integer>>() {{
            for (int i = 0; i < n; i++) {
                put(i, new ArrayList<>());
            }
            for (int[] edge : redEdges) {
                get(edge[0]).add(edge[1]);
            }
        }};

        this.dist = new int[2][n];
        boolean[] visited = new boolean[n];

        Set<Integer> redStart = new HashSet<Integer>() {{
            add(0);
        }};
        Set<Integer> blueStart = new HashSet<Integer>() {{
            add(0);
        }};

        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);
        dist[0][0] = 0;
        dist[1][0] = 0;

        search(redStart, blueStart, 1);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    void search(Set<Integer> redStart, Set<Integer> blueStart, int i) {
        if (redStart.isEmpty() && blueStart.isEmpty()) {
            return;
        }

        Set<Integer> newRedStart = new HashSet<>();
        Set<Integer> newBlueStart = new HashSet<>();
        for (int from : redStart) {
            for (int to : blueMap.get(from)) {
                if (dist[1][to] != Integer.MAX_VALUE) {
                    continue;
                }
                newBlueStart.add(to);
                dist[1][to] = i;
            }
        }

        for (int from : blueStart) {
            for (int to : redMap.get(from)) {
                if (dist[0][to] != Integer.MAX_VALUE) {
                    continue;
                }
                newRedStart.add(to);
                dist[0][to] = i;
            }
        }
        search(newRedStart, newBlueStart, i + 1);
    }

}
