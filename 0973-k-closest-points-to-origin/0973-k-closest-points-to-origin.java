class Solution {
    public int[][] kClosest(int[][] points, int k) {
        double[] distances = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            distances[i] = calculateDistance(points[i]);
        }

        return quickSelect(distances, points, k);
    }

    private int[][] quickSelect(double[] arr, int[][] points, int k) {
        int target = k - 1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int[] range = partition(arr, points, low, high);
            if (target < range[0]) {
                high = range[0] - 1;
            } else if (target > range[1]) {
                low = range[1] + 1;
            } else {
                int[][] ans = new int[k][2];

                for (int i = 0; i < k; i++) {
                    ans[i] = points[i];
                }

                return ans;
            }
        }

        return new int[][] { { -1, -1 } };
    }

    private int[] partition(double[] arr, int[][] points, int low, int high) {
        int pivotIndex = (int) (Math.random() * (high - low + 1)) + low;
        double pivot = arr[pivotIndex];
        int i = low;
        while (i <= high) {
            if (arr[i] < pivot) {
                swap(arr, low, i);
                swap(points, low, i);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, high, i);
                swap(points, high, i);
                high--;
            } else {
                i++;
            }
        }
        return new int[] { low, high };
    }

    private void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private double calculateDistance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }
}