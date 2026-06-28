class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];

        for (int x : arr) {
            freq[Math.min(x, n)]++;
        }

        int ans = 0;

        for (int value = 1; value <= n; value++) {
            ans = Math.min(ans + freq[value], value);
        }

        return ans;
    }
}