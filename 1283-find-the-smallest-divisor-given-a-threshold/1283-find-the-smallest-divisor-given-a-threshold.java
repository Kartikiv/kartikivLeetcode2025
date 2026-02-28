class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int v : nums) right = Math.max(right, v);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ok(nums, mid, threshold)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean ok(int[] nums, int d, int threshold) {
        long sum = 0;
        for (int v : nums) {
            sum += (v + d - 1) / d;   // ceil(v/d)
            if (sum > threshold) return false; // early exit
        }
        return true;
    }
}