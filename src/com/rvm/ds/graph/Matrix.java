package com.rvm.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

class Matrix {

    /*
     * reference https://www.youtube.com/watch?v=QkWjlGxkZdI
     */
    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int level = 0;
        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            level++;
            while (currentQueueSize-- > 0) {
                int[] cell = queue.poll();
                for (int i = 0; i < dir.length; i++) {
                    int r = cell[0] + dir[i][0];
                    int c = cell[1] + dir[i][1];
                    if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] != -1) {
                        continue;
                    }
                    mat[r][c] = level;
                    queue.offer(new int[] { r, c });
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] img = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        matrix.updateMatrix(img);

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }
}
