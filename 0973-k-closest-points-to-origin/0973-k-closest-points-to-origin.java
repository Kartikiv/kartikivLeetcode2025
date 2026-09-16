class Solution {
    public int[][] kClosest(int[][] points, int k) {
       
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k) {
        int target = k - 1;
        int low = 0;
        int high = points.length - 1;
        while (low <= high) {
            int[] range = partition (points, low, high);
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

    private int[] partition(int[][] points, int low, int high) {
        int pivotIndex = (int) (Math.random() * (high - low + 1)) + low;
        int pivot = calculateDistance(points[pivotIndex]);
        int i = low;
        while (i <= high) {
            int distance = calculateDistance(points[i]);
            if (distance < pivot) {
                swap(points, low, i);
                low++;
                i++;
            } else if (distance > pivot) {
                swap(points, high, i);
                high--;
            } else {
                i++;
            }
        }
        return new int[] { low, high };
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}