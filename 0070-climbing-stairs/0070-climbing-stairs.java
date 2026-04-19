class Solution {
    public int climbStairs(int n) {
        return (int) fib(n + 1)[0];
    }

    // returns {F(n), F(n+1)}
    private long[] fib(int n) {
        if (n == 0) return new long[]{0, 1};

        long[] half = fib(n / 2);
        long a = half[0]; // F(k)
        long b = half[1]; // F(k+1)

        long c = a * (2 * b - a);      // F(2k)
        long d = a * a + b * b;        // F(2k+1)

        if (n % 2 == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, c + d};
        }
    }
}