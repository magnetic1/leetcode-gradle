/*
 * Leetcode - reachable_nodes_in_subdivided_graph
 */
package com.leetcode.reachable_nodes_in_subdivided_graph;

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

    int n;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.n = n;

        List<int[]>[] adList = new List[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            adList[u].add(new int[]{v, nodes});
            adList[v].add(new int[]{u, nodes});
        }

        Map<Integer, Integer> used = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(Node.create(0, 0));

        int reachableNodes = 0;
        while (!pq.isEmpty() && pq.peek().dist <= maxMoves) {
            Node node = pq.poll();
            int dist = node.dist, u = node.v;

            if (!visited.add(u)) {
                continue;
            }
            reachableNodes++;

            for (int[] next : adList[u]) {
                int v = next[0], nodes = next[1];
                if (nodes + dist + 1 <= maxMoves && !visited.contains(v)) {
                    pq.offer(Node.create(nodes + dist + 1, v));
                }

                used.put(encode(u, v), Math.min(nodes, maxMoves - dist));
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            reachableNodes += Math.min(nodes, used.getOrDefault(encode(u, v), 0) + used.getOrDefault(encode(v, u), 0));
        }

        return reachableNodes;
    }

    int encode(int u, int v) {
        return u * n + v;
    }

}

class Node {
    public int dist;
    public int v;

    public Node(int dist, int v) {
        this.dist = dist;
        this.v = v;
    }

    public static Node create(int dist, int v) {
        return new Node(dist, v);
    }
}
