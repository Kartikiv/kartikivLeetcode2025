class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        return Math.max(solve(nums, k, true), solve(nums, k, false));
    }

    private long solve(int[] nums, int k, boolean multiply) {
        long NEG = Long.MIN_VALUE / 4;

        long noOp = NEG;
        long inOp = NEG;
        long afterOp = NEG;

        long ans = NEG;

        for (int x : nums) {
            long changed = multiply ? (long) x * k : x / k;

            long newNoOp = Math.max((long) x, noOp + x);

            long newInOp = Math.max(
                changed,
                Math.max(noOp + changed, inOp + changed)
            );

            long newAfterOp = Math.max(
                inOp + x,
                afterOp + x
            );

            noOp = newNoOp;
            inOp = newInOp;
            afterOp = newAfterOp;

            ans = Math.max(ans, Math.max(inOp, afterOp));
        }

        return ans;
    }
}