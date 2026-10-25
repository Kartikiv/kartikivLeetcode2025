import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        // Step 1: Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Step 2: Fenwick tree
        int[] bit = new int[n + 1];
        Integer[] ans = new Integer[n];

        // Step 3: Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            int rank = Arrays.binarySearch(sorted, nums[i]) + 1;

            // Count strictly smaller elements
            int count = 0;
            for (int j = rank - 1; j > 0; j -= j & -j) {
                count += bit[j];
            }

            ans[i] = count;

            // Insert current element
            for (int j = rank; j <= n; j += j & -j) {
                bit[j]++;
            }
        }

        return Arrays.asList(ans);
    }
}