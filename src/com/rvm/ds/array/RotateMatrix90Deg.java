package com.rvm.ds.array;

/**
 * Rotate Image
 * 
 * https://www.scaler.com/topics/course/dsa-interviews-java/video/589/
 */
public class RotateMatrix90Deg {

    public void rotate90(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        printArr(arr);
        System.out.println("************");

        // 1. transpose the matrix by swap the top triangle value with lower values
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        printArr(arr);

        //2.Rotate the Matrix;
        int left = 0, right = col - 1;
        while (left < right) {
            for (int i = 0; i < row; i++) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
            }
            left++;
            right--;
        }
        printArr(arr);

    }

    private void printArr(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        RotateMatrix90Deg deg = new RotateMatrix90Deg();
        deg.rotate90(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        });
    }
}
