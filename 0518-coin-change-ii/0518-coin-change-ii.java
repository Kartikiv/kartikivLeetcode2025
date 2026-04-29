class Solution {
    Integer[][] memo;

    public int change(int amount, int[] coins) {
        memo = new Integer[coins.length][amount + 1];
        return dfs(0, amount, coins);
    }

    private int dfs(int index, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;

        if (memo[index][amount] != null) {
            return memo[index][amount];
        }

        // take current coin (stay on same index)
        int take = dfs(index, amount - coins[index], coins);

        // skip current coin (move to next)
        int skip = dfs(index + 1, amount, coins);

        memo[index][amount] = take + skip;
        return memo[index][amount];
    }
}