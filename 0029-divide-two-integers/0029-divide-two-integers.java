class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;

        // overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long left = 0;
        long right = a;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            if (mid * b <= a) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        long ans = sign * left;

        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}