package com.rvm.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        int countFresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    queue.offer(list);
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0)
            return 0;
        System.out.println(countFresh);
        System.out.println(queue);

        int min = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            min++;
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                List<Integer> list = queue.poll();
                System.out.println(list);
                for (int[] dir : dirs) {
                    int i = list.get(0) + dir[0];
                    int j = list.get(1) + dir[1];
                    if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 1) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(i);
                        list1.add(j);
                        queue.offer(list1);
                        grid[i][j] = 2;
                        countFresh--;
                    }
                }
            }
        }
        System.out.println(countFresh);
        return countFresh == 0 ? min - 1 : -1;
    }

    public static void main(String[] args) {
        RottenOrange orange = new RottenOrange();
        int[][] input = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orange.orangesRotting(input));
    }
}
