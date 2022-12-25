/*
 * Leetcode - building_boxes
 */
package com.leetcode.building_boxes;
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

    public int minimumBoxes(int n) {
        int layers = 1, buttom = 1;
        while (n > buttom) {
            n -= buttom;
            layers++;
            buttom += layers;
        }
        int i = 1, cur = 1;
        while (n > cur) {
            n -= cur;
            i++;
            cur++;
        }
        return buttom - layers + i;
    }

}
