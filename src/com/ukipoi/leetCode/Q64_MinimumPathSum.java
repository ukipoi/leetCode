package com.ukipoi.leetCode;

public class Q64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2}, {1, 1}};
//        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 要点就一个：‘每次只能向下或者向右移动一步’
     * @param grid 网格
     * @return 最短路径
     */
    private static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] path = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    path[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    path[i][j] = path[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    path[i][j] = path[i - 1][j] + grid[i][j];
                    continue;
                }
                path[i][j] = Math.min(path[i][j - 1], path[i - 1][j]) + grid[i][j];
            }
        }
        return path[n - 1][m - 1];
    }
}
