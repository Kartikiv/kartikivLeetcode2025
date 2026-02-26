class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        return mergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] arr, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;

        int mid = (left + right) / 2;
        int count = mergeSort(arr, left, mid, lower, upper)
                  + mergeSort(arr, mid, right, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] temp = new long[right - left];
        int r = 0;

        for (int i = left; i < mid; i++) {

            while (k < right && arr[k] - arr[i] < lower) k++;
            while (j < right && arr[j] - arr[i] <= upper) j++;

            count += j - k;
        }

        // standard merge step
        int i = left;
        j = mid;
        while (i < mid || j < right) {
            if (j == right || (i < mid && arr[i] <= arr[j]))
                temp[r++] = arr[i++];
            else
                temp[r++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }
}