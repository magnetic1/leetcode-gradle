/**
 * Leetcode - integer_to_roman
 */
package com.leetcode.integer_to_roman;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 13) {
            if (num / values[i] > 0) {
                sb.append(rom[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.intToRoman(2569));
    }
}
