package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day45;


import java.util.Deque;
import java.util.LinkedList;

public class NumIslandsBFS {

    private int rows;

    private int cols;


    public static void main(String[] args) {
        NumIslandsBFS solution2 = new NumIslandsBFS();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution2.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution2.numIslands(grid2);
        System.out.println(numIslands2);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    Deque<Integer> deque = new LinkedList<>();
                    deque.addLast(i * cols + j);
                    marked[i][j] = true;
                    while (!deque.isEmpty()) {
                        int cur = deque.poll();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有使用过并且为陆地
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                deque.addLast(newX * cols + newY);
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
