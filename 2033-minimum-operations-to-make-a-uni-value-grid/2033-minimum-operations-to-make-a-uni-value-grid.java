import java.util.*;

class Solution {
    Random rand = new Random();

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int rem = grid[0][0] % x;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != rem) return -1;
            }
        }

        int median = quickSelect(grid, (m * n) / 2);

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.abs(grid[i][j] - median) / x;
            }
        }

        return ans;
    }

    int quickSelect(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = get(matrix, pivotIndex, n);

            int less = left;
            int i = left;
            int greater = right;

            while (i <= greater) {
                int val = get(matrix, i, n);

                if (val < pivot) {
                    swap(matrix, less, i, n);
                    less++;
                    i++;
                } else if (val > pivot) {
                    swap(matrix, i, greater, n);
                    greater--;
                } else {
                    i++;
                }
            }

            if (k < less) {
                right = less - 1;
            } else if (k > greater) {
                left = greater + 1;
            } else {
                return pivot;
            }
        }

        return -1;
    }

    int get(int[][] matrix, int index, int n) {
        return matrix[index / n][index % n];
    }

    void swap(int[][] matrix, int i, int j, int n) {
        if (i == j) return;

        int r1 = i / n, c1 = i % n;
        int r2 = j / n, c2 = j % n;

        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}