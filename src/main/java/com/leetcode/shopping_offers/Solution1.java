/*
 * Leetcode - shopping_offers
 */
package com.leetcode.shopping_offers;

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

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minPrice = Integer.MAX_VALUE;
        int n = price.size();

        for (List<Integer> pack : special) {
            int nextPrice = 0;
            if (checkPackage(pack, price, needs)) {
                nextPrice += pack.get(n);
                for (int i = 0; i < n; i++) {
                    needs.set(i, needs.get(i) - pack.get(i));
                }
                nextPrice += dfs(price, special, needs);
                minPrice = Math.min(nextPrice, minPrice);

                for (int i = 0; i < n; i++) {
                    needs.set(i, needs.get(i) + pack.get(i));
                }
            }
        }

        int tPrice = 0;
        for (int i = 0; i < n; i++) {
            tPrice += needs.get(i) * price.get(i);
        }
        minPrice = Math.min(tPrice, minPrice);
        return minPrice;
    }

    boolean checkPackage(List<Integer> pack, List<Integer> price, List<Integer> needs) {
        int n = needs.size();
        int sumPrice = 0;
        for (int i = 0; i < n; i++) {
            if (pack.get(i) > needs.get(i)) {
                return false;
            }
            sumPrice += pack.get(i) * price.get(i);
        }

        return sumPrice > pack.get(n);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.shoppingOffers(
            Arrays.asList(2, 5),
            Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
            Arrays.asList(3, 2)
        ));
    }

}
