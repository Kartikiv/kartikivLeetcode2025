class Solution {
    public int change(int amount, int[] coins) {

        /*
         below[j] = number of ways to form amount j
                    using coins from (i+1) to end
         top[j]   = number of ways to form amount j
                    using coins from i to end
        */
        int[] below = new int[amount + 1];
        int[] top   = new int[amount + 1];

        /*
         Base case:
         There is exactly 1 way to make amount 0 — choose nothing.
         With no coins left, only below[0] = 1 is valid.
        */
        below[0] = 1;

        /*
         Iterate coins from last to first to enforce combinations
         (so order does NOT matter).
        */
        for (int i = coins.length - 1; i >= 0; i--) {

            /*
             For every coin, amount 0 is always achievable in 1 way:
             by choosing no coins.
            */
            top[0] = 1;
            int coin = coins[i];

            /*
             For each target amount j:
             - Exclude current coin: use result from below[j]
             - Include current coin: stay on same row (top)
               and reduce amount by coin value
            */
            for (int j = 1; j <= amount; j++) {

                /*
                 Exclude case:
                 Do not use current coin at all.
                */
                top[j] = below[j];

                /*
                 Include case:
                 Use current coin at least once.
                 Since coins are unlimited, we stay in same row (top).
                */
                if (j >= coin) {
                    top[j] += top[j - coin];
                }
            }

            /*
             Move current row up for next iteration
             and reset top for reuse.
            */
            below = top;
            top = new int[amount + 1];
        }

        /*
         Final answer:
         Number of ways to form `amount`
         using all coins.
        */
        return below[amount];
    }
}
