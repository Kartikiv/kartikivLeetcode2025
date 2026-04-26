class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Rob houses [0 → n-2] (exclude last)
        int[] robExcludingLast = new int[2];

        // Rob houses [1 → n-1] (exclude first)
        int[] robExcludingFirst = new int[2];

        for (int i = 0; i < n; i++) {

            // Case 1: exclude last house
            if (i <= n - 2) {
                int bestWithCurrent =
                        Math.max(robExcludingLast[1], robExcludingLast[0] + nums[i]);

                robExcludingLast[0] = robExcludingLast[1];
                robExcludingLast[1] = bestWithCurrent;
            }

            // Case 2: exclude first house
            if (i >= 1) {
                int bestWithCurrent =
                        Math.max(robExcludingFirst[1], robExcludingFirst[0] + nums[i]);

                robExcludingFirst[0] = robExcludingFirst[1];
                robExcludingFirst[1] = bestWithCurrent;
            }
        }

        return Math.max(robExcludingLast[1], robExcludingFirst[1]);
    }
}