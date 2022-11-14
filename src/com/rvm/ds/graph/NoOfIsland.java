package com.rvm.ds.graph;

public class NoOfIsland {

    public int getNoOfIsland(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    dfs(matrix, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] matrix, int row, int column, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || column < 0 || row > m - 1 || column > n - 1 || visited[row][column]
                || matrix[row][column] != 1) {
            return;
        }

        visited[row][column] = true;

        dfs(matrix, row - 1, column, visited);
        dfs(matrix, row + 1, column, visited);
        dfs(matrix, row, column - 1, visited);
        dfs(matrix, row, column + 1, visited);
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 1, 1 },
                { 1, 0, 0, 1 },
        };
        NoOfIsland island = new NoOfIsland();
        System.out.println(island.getNoOfIsland(matrix));
    }
}
