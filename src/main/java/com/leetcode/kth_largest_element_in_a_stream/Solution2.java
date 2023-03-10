/**
 * Leetcode - kth_largest_element_in_a_stream
 */
package com.leetcode.kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
public class Solution2 implements Solution { }

class KthLargest1 {
    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}