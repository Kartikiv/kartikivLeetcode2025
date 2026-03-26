import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;

        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean dfs(int max, int total, int usedMask, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedMask)) {
            return memo.get(usedMask);
        }

        for (int i = 1; i <= max; i++) {
            int bit = 1 << i;

            if ((usedMask & bit) != 0) continue;

            if (i >= total) {
                memo.put(usedMask, true);
                return true;
            }

            if (!dfs(max, total - i, usedMask | bit, memo)) {
                memo.put(usedMask, true);
                return true;
            }
        }

        memo.put(usedMask, false);
        return false;
    }
}