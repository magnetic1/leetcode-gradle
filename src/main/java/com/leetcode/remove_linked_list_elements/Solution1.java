/*
 * Leetcode - remove_linked_list_elements
 */
package com.leetcode.remove_linked_list_elements;
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummpy = new ListNode(0, head);

        ListNode pre = dummpy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummpy.next;
    }

}
