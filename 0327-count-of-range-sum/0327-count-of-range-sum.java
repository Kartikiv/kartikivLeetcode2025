import java.util.*;

class Solution {

    static class Fenwick {
        long[] bit;
        Fenwick(int n) { bit = new long[n + 1]; }
        void add(int i, long delta) { // 1-based
            for (; i < bit.length; i += i & -i) bit[i] += delta;
        }
        long sum(int i) { // prefix [1..i]
            long res = 0;
            for (; i > 0; i -= i & -i) res += bit[i];
            return res;
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        // 1) prefix sums (MUST be long)
        long[] psum = new long[n + 1];
        for (int i = 0; i < n; i++) psum[i + 1] = psum[i] + nums[i];

        // 2) coordinate compression using TreeMap: value -> rank (1..m)
        TreeMap<Long, Integer> rank = new TreeMap<>();
        for (long v : psum) rank.put(v, 0);

        int r = 0;
        for (Long key : rank.keySet()) rank.put(key, ++r);

        Fenwick fw = new Fenwick(r);
        long result = 0;

        for (int i = n; i >= 0; i--) {
            long pval = psum[i];

            long low = pval + (long) lower;
            long high = pval + (long) upper;

            // count <= high
            Long hiKey = rank.floorKey(high);
            long cntLeHigh = (hiKey == null) ? 0 : fw.sum(rank.get(hiKey));

            // count < low  (strictly less)
            Long loKey = rank.lowerKey(low);
            long cntLtLow = (loKey == null) ? 0 : fw.sum(rank.get(loKey));

            result += (cntLeHigh - cntLtLow);

            // insert current pval
            fw.add(rank.get(pval), 1);
        }

        return (int) result; // LeetCode expects int; safe for constraints they use
    }
}