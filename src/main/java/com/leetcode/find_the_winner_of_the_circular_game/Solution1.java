/*
 * Leetcode - find_the_winner_of_the_circular_game
 */
package com.leetcode.find_the_winner_of_the_circular_game;
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

    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }

        return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }

}
