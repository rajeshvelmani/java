package com.rvm.ds.graph;

class FloodFill {
    public int[][] floodFill(int[][] image, int i, int j, int color) {
        if (image[i][j] != color)
            dfs(image, i, j, color, image[i][j]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int initColor) {
        int m = image.length;
        int n = image[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != initColor) {
            return;
        }

        image[i][j] = color;
        dfs(image, i, j - 1, color, initColor);
        dfs(image, i, j + 1, color, initColor);
        dfs(image, i - 1, j, color, initColor);
        dfs(image, i + 1, j, color, initColor);
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] img = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        floodFill.floodFill(img, 1, 1, 10);

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }
}
