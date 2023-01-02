/*
 * Leetcode - number_of_orders_in_the_backlog
 */
package com.leetcode.number_of_orders_in_the_backlog;

import java.util.*;
import java.util.function.BiFunction;
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

    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = (int) (1e9 + 7);
        TreeMap<Integer, Integer> buyBacklog = new TreeMap<>();
        TreeMap<Integer, Integer> sellBacklog = new TreeMap<>();

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];

            if (orderType == 0) {
                // buy order type
                while (amount > 0 && !sellBacklog.isEmpty() && price >= sellBacklog.firstKey()) {
                    int sellAmount = sellBacklog.firstEntry().getValue();
                    int matchAmount = Math.min(amount, sellAmount);
                    amount -= matchAmount;
                    if (sellAmount > matchAmount) {
                        sellBacklog.put(sellBacklog.firstKey(), sellAmount - matchAmount);
                    } else {
                        sellBacklog.remove(sellBacklog.firstKey());
                    }
                }
                if (amount > 0) {
                    int finalAmount = amount;
                    buyBacklog.compute(price, (key, oldValue) ->
                            oldValue == null ? finalAmount % mod : (oldValue + finalAmount % mod) % mod
                    );
                }
            } else {
                // sell order type
                while (amount > 0 && !buyBacklog.isEmpty() && price <= buyBacklog.lastKey()) {
                    int buyAmount = buyBacklog.lastEntry().getValue();
                    int matchAmount = Math.min(amount, buyAmount);
                    amount -= matchAmount;
                    if (buyAmount > matchAmount) {
                        buyBacklog.put(buyBacklog.lastKey(), buyAmount - matchAmount);
                    } else {
                        buyBacklog.remove(buyBacklog.lastKey());
                    }
                }
                if (amount > 0) {
                    int finalAmount = amount;
                    sellBacklog.compute(price, (key, oldValue) ->
                            oldValue == null ? finalAmount % mod : (oldValue + finalAmount % mod) % mod
                    );
                }

            }

        }

        int total = 0;
        for (int amount : buyBacklog.values()) {
            total = (total + amount) % mod;
        }
        for (int amount : sellBacklog.values()) {
            total = (total + amount) % mod;
        }
        return total;
    }

    public static void main(String[] args) {
        int mod = (int) (1e9 + 7);
        System.out.println(1999999991 % mod);
    }
}
