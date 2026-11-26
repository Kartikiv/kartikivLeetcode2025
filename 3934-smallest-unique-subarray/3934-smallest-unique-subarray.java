class Solution {
    long MOD = 1_000_000_007;
    long base = 911382323;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] prefixHash = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            prefixHash[i + 1] =
                Math.floorMod(prefixHash[i] * base + nums[i], MOD);

            power[i + 1] = (power[i] * base) % MOD;
        }

        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(prefixHash, power, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

   public boolean check(long[] prefixHash, long[] power, int k) {
    Map<Long, Integer> map = new HashMap<>();
    int n = prefixHash.length - 1;

    for (int i = 0; i + k <= n; i++) {
        long hash = (prefixHash[i + k]
                   - prefixHash[i] * power[k] % MOD
                   + MOD) % MOD;

        map.merge(hash, 1, Integer::sum);
    }

    for (int count : map.values()) {
        if (count == 1) return true;
    }

    return false;
}
}