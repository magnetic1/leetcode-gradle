/**
 * Leetcode - sudoku_solver
 */
package com.leetcode.sudoku_solver;

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
    static int[] rows = new int[9];
    static int[] columns = new int[9];
    static int[] squares = new int[9];


    public void solveSudoku(char[][] board) {
        init(board);

        solveSudoku(board, 0, 0);
    }


    public boolean solveSudoku(char[][] board, int i, int j) {
        char c = board[i][j];

        if (c == '.') {
            for (int k = 0; k < 9; k++) {
                int value = 1 << k;
                if ((rows[i] & value) == 0 & (columns[j] & value) == 0
                        & (squares[(i / 3) * 3 + (j / 3)] & value) == 0) {
                    change(board, i, j, (char) (k + '1'));


                    boolean ok;
                    if (j == 8) {
                        if (i == 8) {
                            return true;
                        } else {
                            ok = solveSudoku(board, i + 1, 0);
                        }
                    } else {
                        ok = solveSudoku(board, i, j + 1);
                    }

                    if (ok) {
                        return true;
                    }
                }
            }
            change(board, i, j, '.');
            return false;
        } else {
            boolean ok;
            if (j == 8) {
                if (i == 8) {
                    return true;
                } else {
                    ok = solveSudoku(board, i + 1, 0);
                }
            } else {
                ok = solveSudoku(board, i, j + 1);
            }
            return ok;
        }
    }


    static void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int value = 1 << (c - '1');
                    rows[i] += value;
                    columns[j] += value;
                    squares[(i / 3) * 3 + (j / 3)] += value;
                }
            }
        }
    }

    static void change(char[][] board, int i, int j, char newChar) {
        char c = board[i][j];
        if (c != '.') {
            int value = 1 << (c - '1');
            rows[i] -= value;
            columns[j] -= value;
            squares[(i / 3) * 3 + (j / 3)] -= value;
        }

        board[i][j] = newChar;

        if (newChar != '.') {
            int value = 1 << (newChar - '1');
            rows[i] += value;
            columns[j] += value;
            squares[(i / 3) * 3 + (j / 3)] += value;
        }

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] chars = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solution.solveSudoku(chars);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(chars[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
